package _03AbstractFactory;

public class FactoryA implements Factory{
    private FactoryA(){};
    private final static FactoryA factory=new FactoryA();
    public static FactoryA getInstance(){
        return factory;
    }


    @Override
    public Phone createPhone() {
        return new PhoneA();
    }

    @Override
    public VideoPlayer creatVideoPlayer() {
        return new VideoPlayerA();
    }
}
