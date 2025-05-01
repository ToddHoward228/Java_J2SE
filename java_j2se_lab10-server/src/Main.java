
public class Main {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        Thread tChatServer = new Thread(server);
        tChatServer.start();
    }
}