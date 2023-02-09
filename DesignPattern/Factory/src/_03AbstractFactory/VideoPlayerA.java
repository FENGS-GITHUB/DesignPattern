package _03AbstractFactory;

public class VideoPlayerA implements VideoPlayer{

    @Override
    public void videoPlay() {
        System.out.println("A品牌的播放器运行了视频播放功能");
    }

    @Override
    public void connection() {
        System.out.println("A品牌播放器运行了连接功能");
    }
}
