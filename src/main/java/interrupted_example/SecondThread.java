package interrupted_example;

/**
 * Created by Шнуренко on 31.01.2015.
 */
public class SecondThread implements Runnable {

    @Override
    public void run() {
        int i = 200;

        while (i > 0) {
            System.out.println("second" + i);
            i--;

            //check state of thread. Main thread can change interrupted status calling interrupt() method
            if (Thread.currentThread().isInterrupted()){
                return;
            }
        }

    }

}

























