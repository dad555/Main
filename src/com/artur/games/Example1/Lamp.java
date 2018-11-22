package com.artur.games.Example1;

public class Lamp implements ElectricityConsumer {
    public void lightOn() {
        System.out.println("Light on!");
    }

    @Override
    public void electricityOn(Object sender) {
        lightOn();
    }
}
