import java.io.*;
import java.net.Socket;

public class ConnectInputMessage implements Runnable {

    private Socket serverConnect;
    private InputStream inputSS;

    public ConnectInputMessage() {
        try {
            serverConnect = new Socket("localhost", 6969);
            inputSS = serverConnect.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try (BufferedReader inFromServer= new BufferedReader(new InputStreamReader(inputSS))){
            String serverMessage;

            while (true){
                serverMessage = inFromServer.readLine();
                if (serverMessage != null){
                    System.out.println(serverMessage + '\n');
                    break;
                }
            }

            PrintWriter outToServer = null;

            try (BufferedReader inputUser = new BufferedReader(new InputStreamReader(System.in))) {
                String userMessage = null;

                while (true){
                    System.out.println("Enter Message: ");
                    userMessage = inputUser.readLine();
                    outToServer = new PrintWriter(serverConnect.getOutputStream(), true);
                    outToServer.println(userMessage);

                    if ("exit".equals(userMessage)){
                        break;
                    }
                }
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
