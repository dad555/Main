package com.artur.learningjava.refactoring.car;

public class Truck extends Car {
    public Truck (int numberOfPassengers) {
        super(Car.TRUCK, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_TRUCK_SPEED;
    }
}
