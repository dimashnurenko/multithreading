package callable_future;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Dmitry Shnurenko
 */
public class MyFuture implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);

        return Thread.currentThread().getName();
    }

    public static void main(String args[]) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<String>> list = new ArrayList<>();

        Callable<String> callable = new MyFuture();
        for (int i = 0; i < 100; i++) {

            Future<String> future = executor.submit(callable);

            list.add(future);
        }
        for (Future<String> fut : list) {
            try {
                System.out.println(new Date() + "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
