package thread.start;

import static util.MyLogger.log;

public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        log(Thread.currentThread().getName() + " : run()");
    }
}
