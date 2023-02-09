package _02lazy;
public class LazySingleLock{
    private LazySingleLock(){	}

    public static LazySingleLock LazyObj;

    public static LazySingleLock getInstance(){

        if (LazyObj==null) {
            synchronized(LazySingleLock.class){
                if (LazyObj==null) {
                    LazyObj=new LazySingleLock();
                }

            }

        }
        return LazyObj;
    }

}