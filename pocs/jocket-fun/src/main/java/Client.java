import jocket.net.JocketSocket;
import java.io.InputStream;
import java.io.OutputStream;

public class Client {
    public static void main(String[] args){
        try{
            System.out.println("Booting up the client(4242). ");
            JocketSocket sock = new JocketSocket(4242);
            InputStream in = sock.getInputStream();
            OutputStream out = sock.getOutputStream();
            System.out.println("Connected. ");

            out.write("123456".getBytes("UTF-8"), 0, "123456".length());
            out.flush();
            System.out.println("Msg sent");

        }catch(Throwable e){
        }

    }
}
