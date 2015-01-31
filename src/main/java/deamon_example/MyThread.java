package deamon_example;

/**
 * Created by Шнуренко on 31.01.2015.
 */
public class MyThread implements Runnable {
    @Override
    public void run() {

        while (true){
            System.out.println("i am daemon");
        }
    }
}
