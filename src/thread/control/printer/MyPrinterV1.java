package thread.control.printer;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;
import static util.MyLogger.*;
import util.ThreadUtils;
import java.util.Scanner;

public class MyPrinterV1 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("인쇄 작업 추가 : ");
            String job = scanner.nextLine();
            if (job.equals("exit")) {
                printer.work = false;
                break;
            }
            printer.addJob(job);
        }
        scanner.close();
    }

    public static class Printer implements Runnable {

        volatile boolean work = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        public void addJob(String job) {
            jobQueue.add(job);
        }

        @Override
        public void run() {
            while (work) {
                if (jobQueue.isEmpty()) {
                    continue;
                }
                String job = jobQueue.poll();
                log("인쇄 작업 시작 : " + job + " 현재 인쇄 대기열 : " + jobQueue);
                ThreadUtils.sleep(3000);
                log("인쇄 작업 완료 : " + job);
            }
            log("인쇄 작업 종료");
        }
    }

}
