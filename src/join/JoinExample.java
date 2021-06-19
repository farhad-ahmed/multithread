package join;

/**
 * This is one example of how thread join() works.
 * Two threads are populating the same array of a singleton object.
 * The main thread is going to populate the even numbers and auxiliary thread will take care of odd numbers.
 * The main thread will wait for the aux thread to complete the work (as it will sleep on each iteration)
 * and print out the bucket items at the end.
 */

public class JoinExample {
    public static void main(String[] args) {
        Bucket bucket = Bucket.getBucket(20);

        int[] bucketList = bucket.getNumberBuckets();

        Thread oddThread = new Thread(new AddOddNumbersToBucket(), "oddThread");

        oddThread.start();

        int n = 0;

        while (n < 20) {
            if (n % 2 == 0) {
                bucketList[n] = n;
            }
            n++;
        }

        waitingForOddThreadToComplete(oddThread);

        printBucket(bucketList);
    }

    private static void waitingForOddThreadToComplete(Thread oddThread) {
        System.out.println(String.format("Main Thread is waiting for Thread [%s]", oddThread.getName()));

        try {
            oddThread.join();
        } catch (InterruptedException ex) {
            System.out.println("Hmm main thread has been interrupted");
        }
    }

    private static void printBucket(int[] bucketList) {
        for (int i = 0; i < bucketList.length; i++) {
            System.out.print(bucketList[i] +" ");
        }
    }
}