package com.artur.patterns.FactoryAbstractFactory;


import com.artur.patterns.FactoryAbstractFactory.female.FemaleFactory;
import com.artur.patterns.FactoryAbstractFactory.male.MaleFactory;

public class FactoryProducer {
    public static enum HumanFactoryType {
        MALE,
        FEMALE,
    }

    public static AbstractFactory getFactory(HumanFactoryType humanFactoryType) {
        if (humanFactoryType.equals(HumanFactoryType.MALE)) {
            return new MaleFactory();
        } else return new FemaleFactory();
    }
}
