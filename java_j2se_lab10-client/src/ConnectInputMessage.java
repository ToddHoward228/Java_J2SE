import java.io.*;
import java.net.Socket;

public class ConnectInputMessage implements Runnable {

    private Socket serverConnect;
    private InputStream inputSS;

    public ConnectInputMessage() {
        try {
            serverConnect = new Socket("localhost", 6999);
            inputSS = serverConnect.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getInputSS() {
        return inputSS;
    }

    @Override
    public void run() {
        try (
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(inputSS));
                PrintWriter outToServer = new PrintWriter(serverConnect.getOutputStream(), true);
                BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String clientInfo = inFromServer.readLine();
            System.out.println(clientInfo);

            Thread receiveThread = new Thread(new ReceiveMessageFromServer(inputSS));
            receiveThread.setDaemon(true);
            receiveThread.start();

            String userMessage;
            while ((userMessage = inputUser.readLine()) != null) {
                outToServer.println(userMessage);
                if ("exit".equalsIgnoreCase(userMessage)) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverConnect.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
