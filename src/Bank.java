public class Bank {
    private int account;
    private final int END = 200000;

    public void inc(){
        for (int i = 1; i < END; i++) {
            System.out.println(account);
            account++;
        }
        System.out.println(account);
    }
    public void dec(){
        for (int i = 1; i < END; i++) {
            System.out.println(account);
            account--;
        }
        System.out.println(account);
    }
}
