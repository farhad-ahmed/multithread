package synchronizedDemo;

public class SyncIncrementTask implements Runnable {

    @Override
    public void run() {
        SyncAccount syncAccount = SyncAccount.getSyncAccount();

        syncAccount.increment();
        syncAccount.increment();

    }
}
