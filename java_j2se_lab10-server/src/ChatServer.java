import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.TreeMap;

public class ChatServer implements Runnable {
    private Map<Integer, Socket> mapClient = new TreeMap<>();

    public void sendMessageForAllClients(int clientID, String message) {

    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(6969);
            System.out.println("Server started");

            int clientID = 0;
            Socket client = null;
            while (true) {
                client = serverSocket.accept();
                Thread clientThread = new Thread(new ClientThread(client, this, clientID));
                clientThread.setDaemon(true);
                clientThread.start();
                mapClient.put(clientID, client);
                clientID++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
