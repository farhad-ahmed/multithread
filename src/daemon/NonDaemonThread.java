package daemon;

/**
 * The main thread will be finished executing code at the end of main method.
 * However, the nonDaemon thread will be executing for infinite of time.
 * As both of the threads are user threads, JVM will never stop executing the application
 */

public class NonDaemonThread {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try{
                        System.out.println("I will be alive even main thread is dead : " + Thread.currentThread().getName());
                        Thread.sleep(1000);
                    }catch (InterruptedException exception){

                    }
                }
            }
        };

        Thread nonDaemonThread = new Thread(runnable, "immortal thread");

        System.out.println("Main Thread is dead now "+Thread.currentThread().getName());

        nonDaemonThread.start();
    }
}
