
public class Main {
    public static void main(String[] args) {
        ConnectInputMessage serverConnection = new ConnectInputMessage();
        Thread tConnectIM = new Thread(serverConnection);
        tConnectIM.start();
    }
}