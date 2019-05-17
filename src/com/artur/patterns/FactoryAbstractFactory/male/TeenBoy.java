package com.artur.patterns.FactoryAbstractFactory.male;

import com.artur.patterns.FactoryAbstractFactory.Human;

public class TeenBoy implements Human {
    public final static int MAX_AGE = 19;

    @Override
    public String toString() {
        return "TeenBoy{}";
    }
}
