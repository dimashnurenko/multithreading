package count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Шнуренко on 03.02.2015.
 */
public class MyThread extends Thread {

    private final CountDownLatch latch;

    public MyThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();


            System.out.println("starting" + getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
