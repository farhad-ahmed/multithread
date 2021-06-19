package join;

public class Bucket {

    private static Bucket bucketInstance;

    private int[] numberBuckets;

    private Bucket(int size) {

        numberBuckets = new int[size];
    }

    public static Bucket getBucket(int size) {
        if (bucketInstance == null) {
            bucketInstance = new Bucket(size);
        }

        return bucketInstance;
    }

    public int[] getNumberBuckets() {
        return numberBuckets;
    }
}