package _01StaticProxy;

/*
* 目标类RealSubject:
*   方法功能为展示出信息实体的姓名
* */
public class RealSubject implements Methods{
    @Override
    public void showInfo(Info info) {
        System.out.println("名字是"+info.getName());

    }
}
