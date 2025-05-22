
public class Main {
    public static void main(String[] args) {
        ConnectInputMessage client = new ConnectInputMessage();
        new Thread(client).start();
    }
}