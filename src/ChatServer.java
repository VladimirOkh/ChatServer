import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    ArrayList<Client> clients = new ArrayList<>();
    ServerSocket serverSocket;

    ChatServer() throws IOException {
        serverSocket = new ServerSocket(1234);
    }

    void sendAll(String message){

    }

    public void run(){
        while (true){
            System.out.println("Waiting...");

            try{
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                clients.add(new Client(socket));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
