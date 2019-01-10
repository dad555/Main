package com.artur.learningjava.refactoring.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    static public final int MAX_TRUCK_SPEED = 80;
    static public final int MAX_SEDAN_SPEED = 120;
    static public final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
        fuel += numberOfLiters;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if (isSummer(date, SummerStart, SummerEnd)) {
            return getSummerConsumption(length);
        } else {
            return getWinterConsumption(length);
        }
    }

    public boolean isSummer(Date date, Date SummerStart, Date SummerEnd) {
        if (date.before(SummerStart) || date.after(SummerEnd)) return false;
        else return true;
    }

    public double getWinterConsumption(int length) {
        return (double) length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return (double) length * summerFuelConsumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred()) return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

    public static Car create(int type, int numberOfPassengers) {
        Car instance = null;
        if (type == TRUCK) {
            instance = new Truck(numberOfPassengers);
        } else if (type == CABRIOLET) {
            instance = new Cabriolet(numberOfPassengers);
        } else if (type == SEDAN) {
            instance = new Sedan(numberOfPassengers);
        }
        return instance;
    }

    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() && fuel > 0;
    }
}

