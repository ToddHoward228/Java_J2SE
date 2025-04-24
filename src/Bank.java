public class Bank {
    private int account;
    private final int END = 20000;

    public synchronized void inc(){
        account = 0;
        for (int i = 0; i < END; i++) {
            System.out.println(account);
            account++;
        }
        System.out.println(account);
    }
    public synchronized void dec(){
        account = END;
        for (int i = 0; i < END; i++) {
            System.out.println(account);
            account--;
        }
        System.out.println(account);
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }
}
