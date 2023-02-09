package _02FctoryMethod;

public class FactoryA implements Factory{

    private FactoryA(){};
    public final static Factory factory=new FactoryA();
    public static Factory getInstance(){
        return factory;
    }

    @Override
    public Product getProduct() {
        return new ProductA();
    }

}
