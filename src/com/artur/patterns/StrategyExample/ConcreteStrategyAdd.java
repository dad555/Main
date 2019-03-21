package com.artur.patterns.StrategyExample;

// Реализуем алгоритм с использованием интерфейса стратегии
public class ConcreteStrategyAdd implements Strategy {
    @Override
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategyAdd's execute()");
        return a + b; // Do an addition with a and b
    }
}
