public class Thread1 implements Runnable {

    final Bank bank;

    public Thread1(Bank b) {
        bank = b;
    }


    @Override
    public void run() {
        synchronized (bank) {

            for (int i = 1; i <= 200000; i++) {
                bank.setAccount(bank.getAccount() + 2);
            }
        }
        System.out.println("Increment thread : " + bank.getAccount());
    }
}
