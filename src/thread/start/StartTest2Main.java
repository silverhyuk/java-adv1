package thread.start;

public class StartTest2Main {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new CounterRunnable(), "counter");
        thread1.start();
    }

    static class CounterRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
