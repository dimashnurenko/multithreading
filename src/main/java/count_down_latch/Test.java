package count_down_latch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Шнуренко on 03.02.2015.
 */
public class Test {

    private static final int THREADS_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        for (int i = 0; i < THREADS_COUNT; i++) {
            new MyThread(latch).start();
        }

        for (int i = 5; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }

        System.out.println("Start ...");

        latch.countDown();
    }
}
