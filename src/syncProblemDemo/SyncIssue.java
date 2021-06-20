package syncProblemDemo;

/**
 * This is one demo of synchronization issue. Two Threads are accessing the same singleton object (NonSyncAccount)
 * The main thread will increase the amount one time and the other thread will increase the value twice.
 * The expectation result will be 3 but the real value will be !=3
 */

public class SyncIssue {

    public static void main(String[] args) throws InterruptedException {
        NonSyncAccount nonSyncAccount = NonSyncAccount.getNonSyncAccount();

        Thread thread = new Thread(new IncrementTask(), "side kick thread");

        thread.start();

        nonSyncAccount.increment();

        thread.join();

        System.out.println(String.format("The final value should be [3.0] and the value is [%s]", nonSyncAccount.getAmount()));
    }
}