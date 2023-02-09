package _01SimpleFactory;

public class Factory{
    private Factory(){};
    public final static Factory factory=new Factory();
    public static Factory getInstance(){
        return factory;
    }

    public static Product getProduct(String ProductName){
        if(ProductName.equals("ProductA")){
            return new ProductA();
        }else if (ProductName.equals("ProductB")){
            return new ProductB();
        }else{
            return  null;
        }
    }

}