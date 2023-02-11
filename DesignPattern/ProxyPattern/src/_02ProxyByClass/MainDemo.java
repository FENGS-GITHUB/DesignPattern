package _02ProxyByClass;

import java.lang.reflect.Proxy;

public class MainDemo {
    public static void main(String[] args) {
        RealSubject realSubject=new RealSubject();
        Handler handler=new Handler(realSubject);
        ProxyMethods m = (ProxyMethods) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),handler );
        m.testMethod();

    }
}
