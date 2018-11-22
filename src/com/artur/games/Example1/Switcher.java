package com.artur.games.Example1;

import java.util.*;

public class Switcher {

    private List<ElectricityConsumer> listeners = new ArrayList<>();

    public void addElectricityListener (ElectricityConsumer listener) {
        listeners.add(listener);
    }

    public void removeElectricityListener (ElectricityConsumer listener) {
        listeners.remove(listener);
    }

    public void switchOn() {
        System.out.println("Switch on!");
        for(ElectricityConsumer e : listeners) {
            e.electricityOn(this);
        }
    }
}

