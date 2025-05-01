package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class MyLogger {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(Object obj) {
        String time = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }

}