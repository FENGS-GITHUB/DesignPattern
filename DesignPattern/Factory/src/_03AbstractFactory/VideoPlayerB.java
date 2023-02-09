package _03AbstractFactory;

public class VideoPlayerB implements VideoPlayer{
    @Override
    public void videoPlay() {
        System.out.println("B品牌的播放器运行了播放功能");
    }

    @Override
    public void connection() {
        System.out.println("B品牌的播放器实现了连接功能");
    }
}
