package cyclic_barier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by Шнуренко on 03.02.2015.
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(3);

        for (int i = 0; i < 12; i++) {
            new MyThread(barrier).start();
            Thread.sleep(1000);
        }
    }
}
