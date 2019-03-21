package com.artur.patterns.StrategyExample;

// Класс реализующий конкретную стратегию, должен реализовывать этот интерфейс
// Класс контекста использует этот интерфейс для вызова конкретной стратегии
public interface Strategy {
    int execute(int a, int b);
}
