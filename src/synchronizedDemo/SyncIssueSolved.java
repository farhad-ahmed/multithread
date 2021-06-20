package synchronizedDemo;

public class SyncIssueSolved {

    public static void main(String[] args) throws InterruptedException {
        SyncAccount syncAccount = SyncAccount.getSyncAccount();

        System.out.println("Initial Value in Account "+syncAccount.getAmount());

        Thread thread = new Thread(new SyncIncrementTask(), "side kick thread");

        thread.start();

        syncAccount.increment();

        thread.join();

        System.out.println(String.format("The final value should be [3.0] and the value is [%s]", syncAccount.getAmount()));
    }
}
