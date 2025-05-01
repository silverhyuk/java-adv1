package util;

import static util.MyLogger.log;

public class MyLoggerMain {
    public static void main(String[] args) {
        MyLogger.log("Hello, World!");
        MyLogger.log(123);
        MyLogger.log(123.456);
        MyLogger.log(true);
        MyLogger.log(new Object());
    }
}
