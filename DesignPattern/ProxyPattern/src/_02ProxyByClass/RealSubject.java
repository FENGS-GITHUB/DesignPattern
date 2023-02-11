package _02ProxyByClass;

public class RealSubject implements ProxyMethods {
    @Override
    public void testMethod() {
        System.out.println("本语句为目标类本身的方法");
    }
}
