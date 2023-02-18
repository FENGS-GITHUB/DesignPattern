package _01SimpleStrategy.strategy.Impl;

import _01SimpleStrategy.strategy.Strategy;

public class MinusOperation implements Strategy {
    @Override
    public int Operation(int A, int B) {
        return A-B;
    }
}
