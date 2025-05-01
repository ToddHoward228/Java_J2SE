import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {
    Socket clientSocket;
    ChatServer server;
    int clientID;

    public ClientThread(Socket clientSocket, ChatServer server, int clientID) {
        this.clientSocket = clientSocket;
        this.server = server;
        this.clientID = clientID;
    }

    @Override
    public void run() {
        try {
            BufferedReader inFromClient = new BufferedReader((new InputStreamReader(clientSocket.getInputStream())));

            System.out.println("Client " + clientID + " connected");

            new PrintWriter(clientSocket.getOutputStream(), true).println("Client " + clientID + '.');
            String clientMessage = null;

            while (true) {

                clientMessage = inFromClient.readLine();

                if (!"exit".equals(clientMessage)) {
                    System.out.println("Message received: " + clientMessage);

                    server.sendMessageForAllClients(clientID, clientMessage);
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
