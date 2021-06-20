package levellocking;

import java.time.LocalTime;

public class AccountPojo {

    private double balance;

    public synchronized void increment() {
        System.out.println("Hello  Thread " + Thread.currentThread().getName() + " time is " + LocalTime.now());

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        balance++;
    }

    public synchronized static void print() {
        System.out.println(String.format("Hello there %s time is %s", Thread.currentThread().getName(), LocalTime.now()));

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {

        }
    }
}
