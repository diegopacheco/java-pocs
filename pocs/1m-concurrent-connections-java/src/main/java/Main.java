import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Semaphore;

public class Main {

  private static final int SERVER_PORT = 9999;
  private static final TimeZone tz = TimeZone.getTimeZone("UTC");
  private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
  static {
    df.setTimeZone(tz);
  }

  public static void print(String msg) {
    System.out.print(df.format(new Date()));
    System.out.print("\t");
    System.out.println(msg);
  }

  public static void main(String[] args) throws Exception {

    int numberOfConnections = Integer.parseInt(args[0]);
    int connectionsPerAddress = 5000;
    if (args.length == 2) {
      connectionsPerAddress = Integer.parseInt(args[1]);
    }

    Semaphore waitForServerStartup = new Semaphore(0);
    Thread serverThread = new Thread(
            () -> {
              List<Socket> tcpSocketsFromClient = Collections.synchronizedList(new ArrayList<>(numberOfConnections));
              Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                print("Shutting down sockets from client");
                try {
                  for(Socket socket : tcpSocketsFromClient) {
                    socket.close();;
                  }
                } catch (IOException e) {

                }
              }));

              try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT, numberOfConnections, null)) {
                waitForServerStartup.release();

                // accumulate all the connections
                for (int i = 0; i < numberOfConnections; i++) {
                  Socket tcpSocketFromClient = serverSocket.accept();
                  tcpSocketsFromClient.add(tcpSocketFromClient);
                  print(
                          "SERVER: " + i
                                  + " from " + tcpSocketFromClient.getInetAddress()
                                  + ":" + tcpSocketFromClient.getPort()
                                  + " to " + tcpSocketFromClient.getLocalAddress()
                                  + ":" + tcpSocketFromClient.getLocalPort()
                  );
                }

                // Send a message to make sure all the connections still work
                // by send and then receiving something.
                ByteBuffer buffer = ByteBuffer.allocate(4);
                for (int i = 0; i < numberOfConnections; i++) {
                  buffer.putInt(i);
                  tcpSocketsFromClient.get(i).getOutputStream().write(buffer.array());
                  buffer.clear();
                }

                for (int i = 0; i < numberOfConnections; i++) {
                  Socket tcpSocketFromClient = tcpSocketsFromClient.get(i);
                  tcpSocketFromClient.getInputStream().read(buffer.array());
                  int msgFromClient = buffer.getInt();
                  if (i != msgFromClient) {
                    print("ERROR: got " + msgFromClient + " but expected i");
                  }
                  print(
                          "SERVER: " + i
                                  + " from " + tcpSocketFromClient.getInetAddress()
                                  + ":" + tcpSocketFromClient.getPort()
                                  + " to " + tcpSocketFromClient.getLocalAddress()
                                  + ":" + tcpSocketFromClient.getLocalPort()
                                  + " msg " + msgFromClient
                  );
                  buffer.clear();
                }

              } catch (IOException e) {
                e.printStackTrace();
              } finally {
                for (Socket socket : tcpSocketsFromClient) {
                  try {
                    socket.close();
                  } catch (IOException e) {
                    e.printStackTrace();
                  }
                }
              }
            });
    serverThread.start();

    // once the server is accepting connections clients can start connecting.
    waitForServerStartup.acquire();

    List<Socket> tcpConnectionsToServer = Collections.synchronizedList(new ArrayList<>(numberOfConnections));
    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      print("Shutting down sockets to server");
      try {
        for(Socket socket : tcpConnectionsToServer) {
          socket.close();;
        }
      } catch (IOException e) {

      }
    }));

    try {
      // establish all connections
      int idx = 0;
      int address = 0;
      label:
      while (true) {
        for (int j = 0; j < connectionsPerAddress; j++) {
          Socket tcpConnectionToServer = new Socket(
                  InetAddress.getByName("127.0.0.1"),
                  SERVER_PORT,
                  InetAddress.getByName("10.0.0." + address),
                  0 // next available port
          );
          tcpConnectionsToServer.add(tcpConnectionToServer);
          idx++;
          if (idx >= numberOfConnections) {
            break label;
          }
        }
        address++;
      }

      // Receive a message to make sure all the connections still work
      // by send and then receiving something.
      ByteBuffer buffer = ByteBuffer.allocate(4);
      for (int i = 0; i < numberOfConnections; i++) {
        Socket tcpConnectionToServer = tcpConnectionsToServer.get(i);
        tcpConnectionToServer.getInputStream().read(buffer.array());
        int msgFromServer = buffer.getInt();
        if (i != msgFromServer) {
          print("ERROR: got " + msgFromServer + " but expected i");
        }
        print(
                "CLIENT: " + i
                        + " from " + tcpConnectionToServer.getInetAddress()
                        + ":" + tcpConnectionToServer.getPort()
                        + " to " + tcpConnectionToServer.getLocalAddress()
                        + ":" + tcpConnectionToServer.getLocalPort()
                        + " msg " + msgFromServer
        );
        buffer.clear();
      }

      // Send a message to make sure all the connections still work
      // by send and then receiving something.
      for (int i = 0; i < numberOfConnections; i++) {
        buffer.putInt(i);
        tcpConnectionsToServer.get(i).getOutputStream().write(buffer.array());
        buffer.clear();
      }

    } finally {
      for (Socket socket : tcpConnectionsToServer) {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }


    serverThread.join();
  }

}