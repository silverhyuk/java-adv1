package thread.control.interrupt;

import util.MyLogger;
import util.ThreadUtils;

public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "worker");
        thread.start();

        ThreadUtils.sleep(4000);
        MyLogger.log("작업 중단 지시 runFlag = false");
        myRunnable.runFlag = false;
    }

    public static class MyRunnable implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            MyLogger.log("작업 시작");
            while (runFlag) {
                MyLogger.log("작업 중");
                ThreadUtils.sleep(3000);
            }
            MyLogger.log("작업종료");
        }
    }
}
