package com.artur.patterns.ChainOfResponsibility;

public class FileLogger extends AbstractLogger {
    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to file: " + message);
    }
}