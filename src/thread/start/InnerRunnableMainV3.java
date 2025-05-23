package thread.start;

import static util.MyLogger.log;

public class InnerRunnableMainV3 {
    public static void main(String[] args) {
        log("start");

        Thread thread = new Thread(() -> log("run()"));
        thread.start();

        log("end");
    }

}
