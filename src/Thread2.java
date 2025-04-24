public class Thread2 implements Runnable {

    Bank bank;

    public Thread2(Bank b) {
        bank = b;
    }

    @Override
    public void run() {
        synchronized (bank) {
            for (int i = 1; i <= 200000; i++) {
                bank.setAccount(bank.getAccount() - 1);
            }
        }
        System.out.println("Decrement thread : " + bank.getAccount());
    }
}
