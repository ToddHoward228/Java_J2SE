import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReceiveMessageFromServer implements Runnable {
    private final InputStream inputSS;

    public ReceiveMessageFromServer(InputStream inputStream) {
        this.inputSS = inputStream;
    }

    @Override
    public void run() {
        try (BufferedReader inFromServer = new BufferedReader(new InputStreamReader(inputSS))) {
            String serverMessage;
            while ((serverMessage = inFromServer.readLine()) != null) {
                System.out.println("\n" + serverMessage + "\nEnter message: ");
            }
        } catch (IOException e) {
            System.err.println("Error receiving message: " + e.getMessage());
        }
    }
}
