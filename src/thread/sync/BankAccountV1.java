package thread.sync;

import util.MyLogger;
import util.ThreadUtils;

public class BankAccountV1 implements BankAccount {
    private int balance;

    public BankAccountV1(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
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
    public int getBalance() {
        return balance;
    }
}
