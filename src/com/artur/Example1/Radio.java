package com.artur.Example1;

public class Radio implements ElectricityConsumer {
    public void radioOn() {
        System.out.println("Radio plays!");
    }

    @Override
    public void electricityOn(Object sender) {
        radioOn();
    }
}
