package interrupt;

/**
 *  Another example of interrupt() thread.
 *  the main thread is asking the chatty thread to stop nicely and the chatty thread will accept the request
 */
public class ChattyButMannerThread {

    public static void main(String[] args) {
        Thread chattyThread = new Thread(() -> {
            while (true) {
                try{
                    System.out.println(Thread.currentThread().getName() + ": Hola! senorita");
                    Thread.sleep(100);
                }catch (InterruptedException ex){
                    System.out.println(Thread.currentThread().getName()+" : Someone is requesting me to stop :(");

                    return;
                }

            }
        }, "chatty thread");

        System.out.println("Main thread is going to start a chatty thread");
        chattyThread.start();

        try{
            Thread.sleep(1000);
        }catch (InterruptedException ex){

        }
        System.out.println("Main thread is going to request chatty thread to stop");
        chattyThread.interrupt();
    }
}