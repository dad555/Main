package com.artur.patterns.FactoryAbstractFactory.male;


import com.artur.patterns.FactoryAbstractFactory.Human;

public class KidBoy implements Human {
    public final static int MAX_AGE = 12;

    @Override
    public String toString() {
        return "KidBoy{}";
    }
}
