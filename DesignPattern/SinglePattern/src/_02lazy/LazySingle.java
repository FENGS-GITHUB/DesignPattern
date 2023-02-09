package _02lazy;

/*懒汉式单例模式
这种单例模式是一种需要才创建的单例模式
该类对象不为空,那么创建该实例对象
判断对象为非空,那么该实例对象就不会创建
*/
public class LazySingle{
    /*私有化构造器,让外部无法创建该类实例对象*/
    private LazySingle(){	}

    /*声明一个空的该类对象*/
    private static LazySingle lazyObj;

    /*获取对象的方法*/
/*判断该声明的对象是否已经创建,若创建则跳出返回该对象
若未创建,则创建一个该对象
*/
    public static LazySingle getInstance(){
        if (lazyObj==null) {
            lazyObj = new LazySingle();
            //该处在多线程情况下可能会存在创建多个对象的情况
			/*
			当线程1执行至if的判断语句之后,创建对象之前,此时lazyObj仍为空
			此时线程2也可以进入if的执行语句之中
			这样就会导致线程1和线程2各自创建一个lazyObj对象
			*/}

        return lazyObj;
    }
}