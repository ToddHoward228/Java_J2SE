
public class Main {
    public static void main(String[] args) {

        Thread serverThread = new Thread(new ChatServer());
        serverThread.start();
    }
}