package join;

public class AddOddNumbersToBucket implements Runnable {
    @Override
    public void run() {
        Bucket bucket = Bucket.getBucket(20);

        int[] bucketList = bucket.getNumberBuckets();

        int n = 1;

        while (n < 20) {
            if (n % 2 != 0) {
                bucketList[n] = n;
            }
            n++;

            goSleep();
        }
    }

    private void goSleep(){
        try {
            Thread.sleep(30);
        } catch (InterruptedException interruptedException) {
            System.out.print("Thread has been interrupted");
        }
    }
}