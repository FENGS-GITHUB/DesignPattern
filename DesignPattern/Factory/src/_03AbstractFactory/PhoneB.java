package _03AbstractFactory;

public class PhoneB implements Phone{
    @Override
    public void call() {
        System.out.println("B品牌的电话实现了拨打功能");
    }

    @Override
    public void musicplay() {
        System.out.println("B品牌的电话实现了音乐播放功能");
    }

    @Override
    public void get() {
        System.out.println("B品牌的电话实现了获取功能");
    }
}

