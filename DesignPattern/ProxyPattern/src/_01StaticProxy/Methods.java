package _01StaticProxy;
/*
* 功能接口:
*   可以看作是一个代理类和目标类之间方法的桥梁
*   也可以看作是目标类和代理类构建的大纲与规范
*   有了这个接口的约束,才能实现代理
*       这是因为代理类和目标类必须功能在宏观层面相同,在具体层面实现拓展
* */
public interface Methods {
    public void showInfo(Info info);
}
