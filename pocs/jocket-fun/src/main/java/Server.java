import jocket.net.JocketSocket;
import jocket.net.ServerJocket;

import java.io.InputStream;
import java.io.OutputStream;

public class Server {

    public static void main(String args[]) {

        try {
            System.out.println("Booting up the server(4242) and waiting... ");
            ServerJocket srv = new ServerJocket(4242);
            JocketSocket sock = srv.accept();

            InputStream is = sock.getInputStream();
            OutputStream out = sock.getOutputStream();
            System.out.println("Client connected.");
            String msg = "";
            int c = 0;
            for (int i = 0; i < 4; i++) {
                c = is.read();
                msg += ((char) c);
            }
            System.out.println("Message Got: " + new String(msg));

        } catch (Throwable e) {
        }
    }
}
