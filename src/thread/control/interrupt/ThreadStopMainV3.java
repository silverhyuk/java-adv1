package thread.control.interrupt;

import util.MyLogger;
import util.ThreadUtils;

public class ThreadStopMainV3 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "worker");
        thread.start();

        ThreadUtils.sleep(100);
        MyLogger.log("작업 중단 지시 interrupt() 호출");
        thread.interrupt();
        MyLogger.log("작업 중단 지시 후 인터럽트 상태 : " + thread.isInterrupted());
        MyLogger.log("작업 중단 지시 후 상태 : " + thread.getState());
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            MyLogger.log("작업 시작");

            while (!Thread.currentThread().isInterrupted()) { // 인터럽트 상태가 없으면 계속 작업
                MyLogger.log("작업 중");
            }
            MyLogger.log("작업 중단 지시 받음. 인터럽트 상태 : " + Thread.currentThread().isInterrupted());

            try {
                MyLogger.log("작업 정리 중");
                Thread.sleep(3000);
                MyLogger.log("작업 정상 종료"); // 정상 종료가 되지 않는다.
            } catch (InterruptedException e) {
                MyLogger.log("작업 정리 중 인터럽트 발생" + e.getMessage());
                MyLogger.log("작업 정리 중 인터럽트 상태 : " + Thread.currentThread().isInterrupted());
            }

            MyLogger.log("작업종료");
        }
    }
}
