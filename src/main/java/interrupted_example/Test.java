package interrupted_example;

/**
 * Created by Шнуренко on 31.01.2015.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        SecondThread secondThread = new SecondThread();

        Thread thread = new Thread(secondThread);
        //we start additional thread
        thread.start();

        Thread.sleep(2);

        //we try stop additional thread
        thread.interrupt();

        System.out.println("i am got up");
        thread.isInterrupted();

    }
}
