package locks_example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Шнуренко on 31.01.2015.
 */
public class MyBank {

    private final int accounts[];
    private Lock bankLock = new ReentrantLock();
    private Condition condition = bankLock.newCondition();

    public MyBank(int n, int initialBalance) {
        accounts = new int[n];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = initialBalance;
        }
    }

    public void transfer(int from, int to, int amount) throws InterruptedException {
        bankLock.lock();
        try {
            while (accounts[from] < amount) {
                condition.await(); //поток снимает блокировку и ждет пока другой поток положит деньги на счет
            }
            String currentThread = Thread.currentThread().toString();

            accounts[from] -= amount;

            accounts[to] += amount;

            System.out.println(currentThread + ' ' + amount + " from " + from + " to " + to + " Balance: " + getTotalBalance());

            condition.signalAll();
        } finally {
            bankLock.unlock();
        }

    }

    public double getTotalBalance() {
        double sum = 0;

        for (double a : accounts) {
            sum += a;
        }

        return sum;
    }

    public int size() {
        return accounts.length;
    }


}
