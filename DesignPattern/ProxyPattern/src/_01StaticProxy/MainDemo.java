package _01StaticProxy;

public class MainDemo {
    public static void main(String[] args) {

        Info info =new Info("张三","001","1388888");
        System.out.println("目标类测试=========");
        new RealSubject().showInfo(info);

        System.out.println("代理类测试=========");
        Proxy proxy =new Proxy();
        proxy.showInfo(info);
    }
}
