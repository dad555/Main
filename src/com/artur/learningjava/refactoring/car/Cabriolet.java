package com.artur.learningjava.refactoring.car;

public class Cabriolet extends Car {
    public Cabriolet (int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
