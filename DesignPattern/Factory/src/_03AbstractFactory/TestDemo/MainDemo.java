package _03AbstractFactory.TestDemo;

import _03AbstractFactory.*;

public class MainDemo {
    public static void main(String[] args) {
        FactoryA factoryA = FactoryA.getInstance();
        FactoryB factoryB = FactoryB.getInstance();
        Phone phoneA1 = factoryA.createPhone();
        VideoPlayer videoPlayerA1 = factoryA.creatVideoPlayer();

        Phone phoneB1 = factoryB.createPhone();
        VideoPlayer videoPlayerB1 = factoryB.creatVideoPlayer();

        phoneA1.call();
        phoneA1.get();
        phoneA1.musicplay();
        phoneB1.call();
        phoneB1.get();
        phoneB1.musicplay();


        videoPlayerA1.videoPlay();
        videoPlayerB1.videoPlay();
        videoPlayerA1.connection();
        videoPlayerB1.connection();
    }

}
