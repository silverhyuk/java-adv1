package thread.start;

/**
 * `Thread-A` , `Thread-B` 두 스레드를 만들어라
 * `Thread-A` 는 1초에 한 번씩 "A"를 출력한다.
 * `Thread-B` 는 0.5초에 한 번씩 "B"를 출력한다.
 *  이 프로그램은 강제 종료할 때 까지 계속 실행된다.
 */
public class StartTest4Main {
    public static void main(String[] args) {
    
        // Create a thread using the Thread class
        Thread threadA = new Thread(new CounterThread("A", 1000), "Thread-A");
        Thread threadB = new Thread(new CounterThread("B", 500), "Thread-B");

        // Start the threads
        threadA.start();
        threadB.start();

        // Keep the main thread alive to allow the other threads to run
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
    static class CounterThread extends Thread {
        private String name;
        private int interval;

        public CounterThread(String name, int interval) {
            this.name = name;
            this.interval = interval;
        }

        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + " : " + name);
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
