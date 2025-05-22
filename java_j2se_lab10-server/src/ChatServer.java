import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ChatServer implements Runnable {

    private final Map<Integer, Socket> mapClient = new ConcurrentHashMap<>();

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(6999)) {
            System.out.println("Server started on port 6999...");

            int clientID = 0;

            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("New connection from: " + client.getInetAddress());

                mapClient.put(clientID, client);
                Thread clientThread = new Thread(new ClientThread(client, this, clientID));
                clientThread.setDaemon(true);
                clientThread.start();
                clientID++;
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    public synchronized void sendMessageForAllClients(int senderId, String message) {
        for (Map.Entry<Integer, Socket> entry : mapClient.entrySet()) {
            int clientId = entry.getKey();
            Socket socket = entry.getValue();

            if (clientId != senderId && socket != null && !socket.isClosed()) {
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Client " + senderId + ": " + message);
                } catch (IOException e) {
                    System.err.println("Error sending to client " + clientId + ": " + e.getMessage());
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    mapClient.remove(clientId);
                }
            }
        }
    }

    public synchronized void removeClient(int clientId) {
        Socket socket = mapClient.remove(clientId);
        try {
            if (socket != null) socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
