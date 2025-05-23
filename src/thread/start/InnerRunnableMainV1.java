package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        log("start");

        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();

        log("end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("MyRunnable : run()");
        }
    }
}
