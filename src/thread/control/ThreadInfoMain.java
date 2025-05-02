package thread.control;

import static util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        
        Thread mainThread = Thread.currentThread();
        log("mainThread: " + mainThread);
        log("mainThread.getName(): " + mainThread.getName());
        log("mainThread.threadId(): " + mainThread.threadId());
        log("mainThread.getPriority(): " + mainThread.getPriority());
        log("mainThread.getState(): " + mainThread.getState());
        log("mainThread.getContextClassLoader(): " + mainThread.getContextClassLoader());
        log("mainThread.getStackTrace(): " + mainThread.getStackTrace());
        log("mainThread.getThreadGroup(): " + mainThread.getThreadGroup());
        log("mainThread.getUncaughtExceptionHandler(): " + mainThread.getUncaughtExceptionHandler());     
        
        Thread myThread = new Thread(new MyRunnable(), "MyThread");
        log("myThread: " + myThread);
        log("myThread.getName(): " + myThread.getName());
        log("myThread.threadId(): " + myThread.threadId());
        log("myThread.getPriority(): " + myThread.getPriority());
        log("myThread.getState(): " + myThread.getState());
        log("myThread.getContextClassLoader(): " + myThread.getContextClassLoader());
        log("myThread.getStackTrace(): " + myThread.getStackTrace());
        log("myThread.getThreadGroup(): " + myThread.getThreadGroup());
        log("myThread.getUncaughtExceptionHandler(): " + myThread.getUncaughtExceptionHandler());
        myThread.start();


    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            Thread myThread = Thread.currentThread();
            log("myThread: " + myThread);
            log("myThread.getName(): " + myThread.getName());
            log("myThread.threadId(): " + myThread.threadId());
            log("myThread.getPriority(): " + myThread.getPriority());
            log("myThread.getState(): " + myThread.getState());
            log("myThread.getContextClassLoader(): " + myThread.getContextClassLoader());
            log("myThread.getStackTrace(): " + myThread.getStackTrace());
            log("myThread.getThreadGroup(): " + myThread.getThreadGroup());
            log("myThread.getUncaughtExceptionHandler(): " + myThread.getUncaughtExceptionHandler());     

            new Thread(new NewRunnable(), "NewThread").start();

        }
    }

    static class NewRunnable implements Runnable {
        @Override
        public void run() {
            Thread myThread = Thread.currentThread();
            log("newThread: " + myThread);
            log("newThread.getName(): " + myThread.getName());
            log("newThread.threadId(): " + myThread.threadId());
            log("newThread.getPriority(): " + myThread.getPriority());
            log("newThread.getState(): " + myThread.getState());
            log("newThread.getContextClassLoader(): " + myThread.getContextClassLoader());
            log("newThread.getStackTrace(): " + myThread.getStackTrace());
            log("newThread.getThreadGroup(): " + myThread.getThreadGroup());
            log("newThread.getUncaughtExceptionHandler(): " + myThread.getUncaughtExceptionHandler());    
        }
    }
}
