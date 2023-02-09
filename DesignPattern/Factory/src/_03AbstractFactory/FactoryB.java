package _03AbstractFactory;

public class FactoryB implements Factory{
    private FactoryB(){};
    private final static FactoryB factory=new FactoryB();
    public static FactoryB getInstance(){
        return factory;
    }



    @Override
    public Phone createPhone() {
        return new PhoneB();
    }

    @Override
    public VideoPlayer creatVideoPlayer() {
        return new VideoPlayerB();
    }

}

