package interrupt;

/**
 *  One example of interrupt() thread.
 *  the main thread is asking the rude thread to stop nicely but rude thread is not going to give a shit
 *  because the rude thread is not handling interruptException.
 *  this program will run forever!!!
 */
public class ThreadThatDoesNotCare {

    public static void main(String[] args) {
        Thread rudeThread = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ": I am not going to stop haha");
            }
        }, "chatty thread");

        System.out.println("Main thread is going to start a chatty thread");
        rudeThread.start();

        rudeThread.interrupt();

    }
}