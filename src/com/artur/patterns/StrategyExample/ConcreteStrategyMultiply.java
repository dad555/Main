package com.artur.patterns.StrategyExample;

// Реализуем алгоритм с использованием интерфейса стратегии
public class ConcreteStrategyMultiply implements Strategy {
    @Override
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategyMultiply's execute()");
        return a * b;   // Do a multiplication with a and b
    }
}
