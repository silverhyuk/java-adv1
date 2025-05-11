package thread.control.join;

import static util.MyLogger.log;
import util.ThreadUtils;

public class JoinMainV0 {
    public static void main(String[] args) {
        log("start");
        Thread jobThread1 = new Thread(new Job(), "job-thread-1");
        Thread jobThread2 = new Thread(new Job(), "job-thread-2");
        jobThread1.start();
        jobThread2.start();

        log("end");
    }

    static class Job implements Runnable {
        @Override
        public void run() {
            log("작업 시작");
            ThreadUtils.sleep(2000);
            log("작업 종료");
        }
    }
}
