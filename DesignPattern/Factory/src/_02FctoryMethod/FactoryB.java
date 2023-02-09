package _02FctoryMethod;


public class FactoryB implements Factory{

    private FactoryB(){};
    public final static Factory factory=new FactoryB();
    public static Factory getInstance(){
        return factory;
    }

    @Override
    public Product getProduct() {
        return new ProductB();
    }


}
