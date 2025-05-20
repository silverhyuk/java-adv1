package thread.control.volatile1;

import util.MyLogger;
import util.ThreadUtils;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "MyTask");
        MyLogger.log("MyTask 시작");
        thread.start();
        ThreadUtils.sleep(1000);

        myTask.setRunFlag(false);
        MyLogger.log("runFlag 변경 : " + myTask.runFlag);
        MyLogger.log("MyTask 종료");
    }

    public static class MyTask implements Runnable {

        // boolean runFlag = true;
        volatile boolean runFlag = true; // volatile 키워드를 사용하면 변수가 메인 메모리에 저장되어 있는 것을 보장함 (캐시 메모리에 저장되어 있는 것을 보장하지 않음)

        @Override
        public void run() {
            while (runFlag) {

            }
            MyLogger.log("MyTask is finished");
        }

        public void setRunFlag(boolean runFlag) {
            this.runFlag = runFlag;
        }
    }
}
