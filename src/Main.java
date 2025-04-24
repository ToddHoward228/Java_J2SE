public class Main {

    public static void main(String[] args) {

        final Bank bank = new Bank();

        Thread t1 = new Thread(new Thread1(bank));
        Thread t2 = new Thread(new Thread2(bank));

        t1.start();
        t2.start();
    }
}