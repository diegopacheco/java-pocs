import sh.blake.niouring.IoUring;
import sh.blake.niouring.IoUringServerSocket;
import sh.blake.niouring.util.ByteBufferUtil;

import java.nio.ByteBuffer;

public class Main {
    public static void main(String[] args) {
        String response = "HTTP/1.1 200 OK\r\n\r\nHello, world!";
        ByteBuffer responseBuffer = ByteBufferUtil.wrapDirect(response);

        IoUringServerSocket serverSocket = new IoUringServerSocket(8080);
        serverSocket.onAccept((ring, socket) -> {
            ring.queueAccept(serverSocket);
            socket.onRead(in -> ring.queueWrite(socket, responseBuffer.slice()));
            ring.queueRead(socket, ByteBuffer.allocateDirect(1024));
            socket.onWrite(out -> socket.close());
            socket.onException(ex -> {
                ex.printStackTrace();
                socket.close();
            });
        });

        new IoUring()
                .onException(Exception::printStackTrace)
                .queueAccept(serverSocket)
                .loop();
    }
}
