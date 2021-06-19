package daemon;

/**
 * The main thread will be finished executing code at the end of main method.
 * Even though the daemon thread has infinite loop, it will be terminated by JVM once user thread (main thread here)
 * is done.
 */

public class DaemonThread {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try{
                        System.out.println(String.format("[%s] : [%s]", Thread.currentThread().getName(), System.currentTimeMillis()));
                        Thread.sleep(1);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        };

        Thread daemonThread = new Thread(runnable, "daemon");

        //making a thread daemon
        daemonThread.setDaemon(true);

        daemonThread.start();

        System.out.println("Main Thread is done here "+System.currentTimeMillis());
    }
}
