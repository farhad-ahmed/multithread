package levellocking;

public class TwoThreadsAccessingSameObjectDemo {
    public static void main(String[] args) {
        AccountPojo a1 = new AccountPojo();

        Thread thread = new Thread(()->a1.increment(), "secondary");

        thread.start();

        a1.increment();

        System.out.println("");
    }
}
