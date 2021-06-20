package levellocking;

/**
 * This is one of the demo that two separate objects are non-blocking to different threads.
 * main and aux threads are accessing different
 */

public class ObjectLevelLockDemo {

    public static void main(String[] args) {
        AccountPojo a1 = new AccountPojo();

        AccountPojo a2 = new AccountPojo();

        Thread thread = new Thread(()->a1.increment(), "aux thread");

        thread.start();

        a2.increment();
    }
}
