package com.example.restaurant.patterns;


public class LoggerSingleton {
    private static LoggerSingleton instance;

    private LoggerSingleton() {}

    public static synchronized LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void log(String info) {
        System.out.println("[SYSTEM LOG]: " + info);
    }
}