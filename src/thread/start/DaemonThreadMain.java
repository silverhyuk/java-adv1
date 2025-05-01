package thread.start;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");

        DaemonThread thread = new DaemonThread();

        thread.setDaemon(true); // 데몬 스레드로 설정
        thread.start(); // 데몬 스레드 시작

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " : main() end");
    }

    static class DaemonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : run() start");

            try {
                Thread.sleep(10000); // 10초 동안 대기
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " : run() end");
        }
    }
}
