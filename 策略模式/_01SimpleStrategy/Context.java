package _01SimpleStrategy;

import _01SimpleStrategy.strategy.Strategy;

public class Context {
    Strategy strategy;

    public Context(Strategy strategy){
        this.strategy=strategy;
    }

    public int doOperation(int A,int B){
        return strategy.Operation(A,B);
    }
}
