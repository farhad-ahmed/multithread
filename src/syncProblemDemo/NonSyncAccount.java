package syncProblemDemo;

public class NonSyncAccount {

    private Double amount;

    private static NonSyncAccount nonSyncAccount;

    private NonSyncAccount(){
        amount = new Double(0);
    }

    public static NonSyncAccount getNonSyncAccount() {
        if(nonSyncAccount == null){
            nonSyncAccount = new NonSyncAccount();
        }

        return nonSyncAccount;
    }

    public Double getAmount(){
        return amount;
    }

    public void increment(){
        double currentValue = getAmount();

        try{
            Thread.sleep(100);
        }catch (InterruptedException e){

        }
        amount = currentValue+1;
    }
}