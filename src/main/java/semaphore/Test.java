package semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by Шнуренко on 02.02.2015.
 */
public class Test {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new Worker(semaphore, "Adder", true).start();
        new Worker(semaphore, "Reducer", false).start();
    }
}
