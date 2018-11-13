package Learning2;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private double speed = 0.03;
    private double distance = 0.0;
    private boolean engineOn = true;
    private List<Double> upgrades = new ArrayList<>();

    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }
    public boolean isEngineOn() { return engineOn; }
    public void setEngineOn(boolean engineOn) {
        this.engineOn = engineOn;

    }

    public void go() {
        try {
            this.distance = distance + speed + 0.001;
            Thread.sleep(1000);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void tap(double i) {
        this.distance = distance + i;
    }

    public void upgradesList(double d) {
        this.upgrades.add(d);
    }

    public void setUpgrade(double d) {
        setSpeed(getSpeed() * d);
    }
}
