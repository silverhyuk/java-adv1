package thread.control.interrupt;

import util.MyLogger;
import util.ThreadUtils;

public class ThreadStopMainV2 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "worker");
        thread.start();

        ThreadUtils.sleep(6000);
        MyLogger.log("작업 중단 지시 interrupt() 호출");
        thread.interrupt();
        MyLogger.log("작업 중단 지시 후 인터럽트 상태 : " + thread.isInterrupted());
        MyLogger.log("작업 중단 지시 후 상태 : " + thread.getState());
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            MyLogger.log("작업 시작");
            try {
                while (true) {
                    MyLogger.log("작업 중");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                MyLogger.log("작업 중단 지시 받음. 인터럽트 상태 : " + Thread.currentThread().isInterrupted());
                MyLogger.log("interrunt message : " + e.getMessage());
                MyLogger.log("state : " + Thread.currentThread().getState());
            }
            MyLogger.log("작업종료");
        }
    }
}
