package _02ProxyByClass;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class Handler implements InvocationHandler {
    Object target=null;

    public Handler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object tempObj=method.invoke(target,args);
        System.out.println("本句代码为代理类中增强的代码");
        return tempObj;

    }
}
