import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    private final Socket clientSocket;
    private final ChatServer server;
    private final int clientID;

    public ClientThread(Socket clientSocket, ChatServer server, int clientID) {
        this.clientSocket = clientSocket;
        this.server = server;
        this.clientID = clientID;
    }

    @Override
    public void run() {
        try (
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter outToClient = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            System.out.println("Client " + clientID + " connected");
            outToClient.println("Your ID is: " + clientID);

            String clientMessage;
            while ((clientMessage = inFromClient.readLine()) != null) {
                if ("exit".equalsIgnoreCase(clientMessage)) {
                    System.out.println("Client " + clientID + " disconnected");
                    break;
                }
                System.out.println("Message from Client " + clientID + ": " + clientMessage);
                server.sendMessageForAllClients(clientID, clientMessage);
            }

        } catch (IOException e) {
            System.err.println("Client " + clientID + " error: " + e.getMessage());
        } finally {
            server.removeClient(clientID);
        }
    }
}
