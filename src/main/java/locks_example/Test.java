package locks_example;

/**
 * Created by Шнуренко on 31.01.2015.
 */
public class Test {

    public static final int NACCOUNTS = 100;
    public static final int INITIAL_BALANCE = 1000;

    public static void main(String[] args) {
        MyBank bank = new MyBank(NACCOUNTS, INITIAL_BALANCE);

        int i;

        for (i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(bank, i, INITIAL_BALANCE);

            Thread thread = new Thread(r);

            thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    System.out.println(t.toString() + ' ' + e);
                }
            });

            thread.start();
        }
    }
}
