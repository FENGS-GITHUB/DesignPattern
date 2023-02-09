package _02lazy.destory;
public class LazySingleLock{
    private LazySingleLock(){
        synchronized(LazySingleLock.class){
            if (LazyObj!=null) {
                throw new RuntimeException("请勿通过反射获取对象");
            }

        }
    /*反射可以通过暴力破解来获取私有的构造器对象
    * 因此在私有化的构造器中添加一个锁,判断为空直接扔出异常
    * */


    }

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