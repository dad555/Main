package Learning1;

public class Ship {
    private double speed = 2.00;
    public boolean engineOn = false;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isEngineOn() {
        return engineOn;
    }

    public void setEngineOn(boolean engineOn) {
        this.engineOn = engineOn;
    }

    public void shipLaunch() {
        this.speed = speed++;
    }

    public void speedUp() {
        this.speed = speed * 1.03d;
    }
}
