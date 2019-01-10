package com.artur.learningjava.refactoring.car;

public class Sedan extends Car {
    public Sedan (int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_SEDAN_SPEED;
    }
}
