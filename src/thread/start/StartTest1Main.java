package thread.start;

public class StartTest1Main {

    public static void main(String[] args) {

        // Create a thread using the Thread class
        Thread thread1 = new Thread(new CounterThread());
        thread1.start();
    }



    static class CounterThread extends Thread {
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
