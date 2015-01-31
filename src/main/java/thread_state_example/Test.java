package thread_state_example;

/**
 * Created by Шнуренко on 31.01.2015.
 */
public class Test {

    public static void main(String[] args) {
        Runnable myThread = new MyThread();

        Thread thread = new Thread(myThread);

        System.out.println(thread.getState());

        thread.start();

        System.out.println(thread.getState());
    }
}
