package thread.control.volatile1;

import util.MyLogger;
import util.ThreadUtils;

public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "MyTask");
        MyLogger.log("MyTask 시작");
        thread.start();
        ThreadUtils.sleep(1000);

        myTask.setFlag(false);
        MyLogger.log("flag : " + myTask.getFlag() + ", count : " + myTask.getCount() + " 메인 스레드 종료");
    }

    static class MyTask implements Runnable {
        // boolean flag = true;
        // long count = 0;

        volatile boolean flag = true;
        volatile long count = 0;

        @Override
        public void run() {
            while (flag) {
                count++;
                // 1억번에 한번씩 출력
                if (count % 100_000_000 == 0) {
                    MyLogger.log("flag : " + flag + ", count : " + count);
                }
            }
            MyLogger.log("MyTask 종료 flag : " + flag + ", count : " + count);
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public long getCount() {
            return count;
        }

        public boolean getFlag() {
            return flag;
        }
    }
}
