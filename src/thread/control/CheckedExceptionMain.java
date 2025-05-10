package thread.control;

import util.ThreadUtils;

public class CheckedExceptionMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            ThreadUtils.sleep(1000);
        }
    }
}
