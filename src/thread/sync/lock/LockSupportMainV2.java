package thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import util.ThreadUtils;
import util.MyLogger;

public class LockSupportMainV2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTask(), "Thread-1");
        thread1.start();
        // 잠시 대기하여 Thread-1이 park 상태에 빠질 시간을 준다.
        ThreadUtils.sleep(100);
        MyLogger.log("Thread-1 state: " + thread1.getState());
    }

    static class ParkTask implements Runnable {
        @Override
        public void run() {
            MyLogger.log("park 시작");
            LockSupport.parkNanos(2000_000_000); // 2초 대기
            MyLogger.log("park 종료, state: " + Thread.currentThread().getState());
            MyLogger.log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}