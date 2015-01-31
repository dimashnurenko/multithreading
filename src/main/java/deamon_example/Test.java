package deamon_example;

/**
 * Created by Шнуренко on 31.01.2015.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Runnable myThread = new MyThread();

        Thread thread = new Thread(myThread);
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(1);

        System.out.println("program is executed and daemon is died");
    }
}
