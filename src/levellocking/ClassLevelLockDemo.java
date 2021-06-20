package levellocking;

/**
 * Class level synchronized. It will keep one thread wait.
 */

public class ClassLevelLockDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(()->AccountPojo.print(), "secondary");

        thread.start();

        AccountPojo.print();
    }
}