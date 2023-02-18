package _01SimpleStrategy;

import _01SimpleStrategy.strategy.Impl.ByOperation;
import _01SimpleStrategy.strategy.Impl.MinusOperation;
import _01SimpleStrategy.strategy.Impl.PlusOperation;

public class TestDemo {
    public static void main(String[] args) {
        Context OperationExecutor=null;
        OperationExecutor=new Context(new MinusOperation());
        System.out.println(OperationExecutor.doOperation(1,2));

        OperationExecutor=new Context(new PlusOperation());
        System.out.println(OperationExecutor.doOperation(3,5));

        OperationExecutor=new Context(new ByOperation());
        System.out.println(OperationExecutor.doOperation(9,5));


    }


}
