package _01StaticProxy;
/*
* 代理类:Proxy类
*   该类在方法上,完成了目标类RealSubject的拓展
*   目标类方法功能为:展示出Info类信息实体中的姓名方法
*   代理类拓展增强:展示姓名,ID,和电话号
* */
public class Proxy implements Methods{

    @Override
    public void showInfo(Info info) {
        new RealSubject().showInfo(info);
        System.out.println("ID是"+info.getID());
        System.out.println("电话是"+info.getTel());

    }
}
