package Learning2;

import java.util.ArrayList;
import java.util.List;

public class Wealth {
    private double earnings = 0.01;
    private double wealthSize = 0.0;
    private boolean isAlive = true;

    public double getEarnings() {
        return earnings;
    }

    public void setEarnings(double earnings) {
        this.earnings = earnings;
    }

    public double getWealthSize() {
        return wealthSize;
    }

    public void setWealthSize(double wealthSize) {
        this.wealthSize = wealthSize;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void go() {
        try {
            this.wealthSize = wealthSize + earnings;
            Thread.sleep(1000);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void tap(double i) {
        this.wealthSize = wealthSize + i;
    }
}
