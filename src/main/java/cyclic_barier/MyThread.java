package cyclic_barier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Шнуренко on 03.02.2015.
 */
public class MyThread extends Thread {

    private CyclicBarrier barrier;

    public MyThread(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("before barier");

            barrier.await();

            System.out.println("started");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
