package thread.sync;

import util.MyLogger;
import util.ThreadUtils;

public class BankAccountV2 implements BankAccount {
    private volatile int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {
        MyLogger.log("withdraw 시작 " + getClass().getSimpleName() + " balance : " + balance);

        if (balance < amount) {
            MyLogger.log(
                    "withdraw 실패 " + getClass().getSimpleName() + " balance : " + balance + ", amount : " + amount);
            return false;
        }

        ThreadUtils.sleep(1000);

        balance -= amount;
        MyLogger.log("withdraw 성공 " + getClass().getSimpleName() + " balance : " + balance + ", amount : " + amount);

        MyLogger.log("withdraw 종료 " + getClass().getSimpleName() + " balance : " + balance);
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }
}
