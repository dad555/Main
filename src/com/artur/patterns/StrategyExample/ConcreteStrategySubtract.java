package com.artur.patterns.StrategyExample;

// Реализуем алгоритм с использованием интерфейса стратегии
public class ConcreteStrategySubtract implements Strategy {
    @Override
    public int execute(int a, int b) {
        System.out.println("Called ConcreteStrategySubtract's execute()");
        return a - b;  // Do a subtraction with a and b
    }
}
