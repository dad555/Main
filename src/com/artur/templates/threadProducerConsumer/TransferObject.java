package com.artur.templates.threadProducerConsumer;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {

            }
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        notifyAll();
        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {

            }
        }
            this.value = value;
            System.out.println("Put: " + value);
            isValuePresent = true;
            notifyAll();
        }
    }

