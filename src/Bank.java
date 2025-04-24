public class Bank {
    private int account;
    private final int END = 20000;

    public void inc(){
        account = 1;
        for (int i = 1; i < END; i++) {
            System.out.println(account);
            account++;
        }
        System.out.println(account);
    }
    public void dec(){
        account = END;
        for (int i = 1; i < END; i++) {
            System.out.println(account);
            account--;
        }
        System.out.println(account);
    }
}
