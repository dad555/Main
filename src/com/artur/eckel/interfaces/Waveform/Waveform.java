package com.artur.eckel.interfaces.Waveform;

public class Waveform {
    private static long counter;
    private final long id = counter++;
    public String toString() {
        return "Waveform " + id;
    }
}
