package _03AbstractFactory;

public class PhoneA implements Phone{
    @Override
    public void call() {
        System.out.println("A品牌的电话实现了拨打功能");
    }

    @Override
    public void musicplay() {
        System.out.println("A品牌的电话实现了音乐播放功能");
    }

    @Override
    public void get() {
        System.out.println("A品牌的电话实现了获取功能");
    }
}
