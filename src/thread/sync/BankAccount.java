package thread.sync;

public interface BankAccount {
    /**
     * 출금
     * 
     * @param amount 출금 금액
     * @return 출금 성공 여부
     */
    boolean withdraw(int amount);

    /**
     * 잔액 조회
     * 
     * @return 잔액
     */
    int getBalance();
}
