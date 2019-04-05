package com.artur.patterns.ChainOfResponsibility;

public abstract class AbstractLogger implements Logger {
    int level;
    Logger next;

    public void inform(String message, int level) {
        if (this.level <= level) {
            info(message);
        }
        if (next != null) {
            next.inform(message, level);
        }
    }

    public void setNext(Logger next) {
        this.next = next;
    }
}
