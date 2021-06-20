package synchronizedDemo;

public class SyncAccount {

    private Double amount;

    private static SyncAccount syncAccount;

    private SyncAccount(){
        amount = new Double(0);
    }

    public static SyncAccount getSyncAccount() {
        if(syncAccount == null){
            syncAccount = new SyncAccount();
        }

        return syncAccount;
    }

    public Double getAmount(){
        return amount;
    }

    public synchronized void increment() {
        double currentValue = getAmount();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        amount = currentValue+1;
    }
}