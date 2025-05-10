package thread.control;

import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable(), "MyThread");
        log("thread.getState() : " + thread.getState());

        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log("thread.getState() : " + thread.getState());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log("thread.getState() : " + thread.getState());

    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {

            try {
                log("start");
                log("thread.getState() : " + Thread.currentThread().getState());
                Thread.sleep(3000);
                log("thread.getState() : " + Thread.currentThread().getState());
                log("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
