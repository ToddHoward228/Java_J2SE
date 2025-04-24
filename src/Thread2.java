public class Thread2 implements Runnable {

    Bank bank;

    public Thread2(Bank b) {
        bank = b;
    }

    @Override
    public void run() {
        bank.dec();
    }
}
