package com.artur.patterns.FactoryAbstractFactory.female;

import com.artur.patterns.FactoryAbstractFactory.Human;

public class TeenGirl implements Human {
    public final static int MAX_AGE = 19;

    @Override
    public String toString() {
        return "TeenGirl{}";
    }
}
