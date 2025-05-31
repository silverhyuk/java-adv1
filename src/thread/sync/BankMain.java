package thread.sync;

import util.MyLogger;
import util.ThreadUtils;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccountV2(1000);
        WithdrawTask withdrawTaskT1 = new WithdrawTask(bankAccount, 800);
        WithdrawTask withdrawTaskT2 = new WithdrawTask(bankAccount, 800);
        Thread t1 = new Thread(withdrawTaskT1, "t1");
        Thread t2 = new Thread(withdrawTaskT2, "t2");
        t1.start();
        t2.start();

        ThreadUtils.sleep(500); // 메인 스레드가 종료되기 전에 자식 스레드의 상태를 확인하기 위해 500ms 대기
        MyLogger.log("t1의 상태 : " + t1.getState());
        MyLogger.log("t2의 상태 : " + t2.getState());

        t1.join();
        t2.join();

        MyLogger.log("최종 잔액 : " + bankAccount.getBalance());
    }
}
