import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
        new Thread(this).start();
    }

    void receive(String message){

    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            Scanner in = new Scanner(is);
            PrintStream out = new PrintStream(os);

            out.println("Welcome to mountains!");
            String input = in.nextLine();
            while (!input.equals("bye")) {
                out.println(input + "-" + input + "-" + input.substring(input.length() / 2) + "...");
                input = in.nextLine();
            }
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
