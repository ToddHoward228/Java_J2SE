public class Thread1 implements Runnable {

    Bank bank;

    public Thread1(Bank b) {
        bank = b;
    }

    @Override
    public void run() {
        bank.inc();
    }
}
