package _01SimpleFactory;

public class ProductB implements Product{

    @Override
    public void use() {
        System.out.println("这是一个产品ProductB");
    }
}
