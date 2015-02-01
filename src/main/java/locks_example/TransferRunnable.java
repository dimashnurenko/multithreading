package locks_example;

/**
 * Created by Шнуренко on 31.01.2015.
 */
public class TransferRunnable implements Runnable {

    private MyBank bank;
    private int fromAcc;
    private int maxAcc;
    private int DELAY = 10;

    public TransferRunnable(MyBank bank, int from, int max) {
        this.bank = bank;
        this.fromAcc = from;
        this.maxAcc = max;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int toAcc = (int) (bank.size() * Math.random());

                int amount =(int) (maxAcc * Math.random());

                bank.transfer(fromAcc, toAcc, amount);

                Thread.sleep((int) (DELAY * Math.random()));
            }
        } catch (InterruptedException e) {

        }
    }
}
