package _01SimpleFactory;

public class ProductA implements Product{

    @Override
    public void use() {
        System.out.println("使用了产品ProductA");
    }
}
