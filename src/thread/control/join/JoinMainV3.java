package thread.control.join;

import static util.MyLogger.log;
import util.ThreadUtils;

public class JoinMainV3 {
    public static void main(String[] args) throws InterruptedException {
        log("start");
        SumTask sumTask1 = new SumTask(1, 50);
        SumTask sumTask2 = new SumTask(51, 100);
        Thread sumThread1 = new Thread(sumTask1, "sum-thread-1");
        Thread sumThread2 = new Thread(sumTask2, "sum-thread-2");
        sumThread1.start();
        sumThread2.start();

        // 모든 스레드가 종료될 때까지 대기
        log("main thread 대기");
        sumThread1.join();
        sumThread2.join();
        log("main thread 대기 종료");

        log("sumTask1.result=" + sumTask1.getResult());
        log("sumTask2.result=" + sumTask2.getResult());

        int total = sumTask1.getResult() + sumTask2.getResult();
        log("total=" + total);

        log("end");
    }

    static class SumTask implements Runnable {

        private int startValue;
        private int endValue;
        private int result = 0;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            ThreadUtils.sleep(2000);
            for (int i = startValue; i <= endValue; i++) {
                result += i;
            }
            log("작업 종료 result=" + result);
        }

        public int getResult() {
            return result;
        }
    }
}
