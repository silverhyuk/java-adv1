package thread.control.printer;

import static util.MyLogger.log;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV2 {
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
                printerThread.interrupt();
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
                try {
                    String job = jobQueue.poll();
                    log("인쇄 작업 시작 : " + job + " 현재 인쇄 대기열 : " + jobQueue);
                    Thread.sleep(3000);
                    log("인쇄 작업 완료 : " + job);
                } catch (InterruptedException e) {
                    log("인터럽트 발생");
                    break;
                }
            }
            log("인쇄 작업 종료");
        }
    }

}
