package syncProblemDemo;

public class IncrementTask implements  Runnable{

    @Override
    public void run() {
        NonSyncAccount nonSyncAccount = NonSyncAccount.getNonSyncAccount();

        nonSyncAccount.increment();

        nonSyncAccount.increment();
    }
}