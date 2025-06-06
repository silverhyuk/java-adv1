package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import util.MyLogger;
import util.ThreadUtils;

public class BankAccountV4 implements BankAccount {
    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        MyLogger.log("withdraw 시작 " + getClass().getSimpleName());

        lock.lock();
        try {
            if (balance < amount) {
                MyLogger.log(
                        "withdraw 실패 " + getClass().getSimpleName() + " balance : " + balance + ", amount : " + amount);
                return false;
            }

            ThreadUtils.sleep(1000);

            balance -= amount;
            MyLogger.log(
                    "withdraw 성공 " + getClass().getSimpleName() + " balance : " + balance + ", amount : " + amount);

            MyLogger.log("withdraw 종료 " + getClass().getSimpleName());
            return true;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public int getBalance() {

        lock.lock();
        try {
            MyLogger.log("getBalance 시작 " + getClass().getSimpleName());
            return balance;
        } finally {
            lock.unlock(); // Ensure the lock is always released
            MyLogger.log("getBalance 종료 " + getClass().getSimpleName());
        }
    }
}
