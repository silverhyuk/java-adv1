package thread.control.test;

import util.ThreadUtils;
import util.MyLogger;
import java.time.LocalDateTime;
import java.time.Duration;

public class JoinTest2Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "t1");
        Thread thread2 = new Thread(new MyRunnable(), "t2");
        Thread thread3 = new Thread(new MyRunnable(), "t3");

        LocalDateTime start = LocalDateTime.now();

        MyLogger.log("main start");
        thread.start();
        thread2.start();
        thread3.start();

        thread.join();
        thread2.join();
        thread3.join();

        MyLogger.log("main end");

        LocalDateTime end = LocalDateTime.now();
        MyLogger.log("time: " + Duration.between(start, end).toSeconds() + " seconds");
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                MyLogger.log(i);
                ThreadUtils.sleep(1000);
            }
        }
    }
}
