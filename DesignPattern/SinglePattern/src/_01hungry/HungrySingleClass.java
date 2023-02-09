package _01hungry;


    /*
饿汉式 单例模式
该模式的类在被加载器加载的时候就创建了这个类的实例对象
这个对象被fianl修饰,无法被更改
该类实例对象只能够创建一次且不能够被外界创建
*/
    public class HungrySingleClass{
        /*
        该类就是一个简单的饿汉式类的一个骨架
        #1构造方法私有化 外界不能够创建该类的实例对象

        #2静态成员属性,在类加载时就会直接创建该成员变量,并在内存中(静态存储区)加载该类成员

        #3创建一个获取方法,让外部可以调用该方法来获取成员变量,也就是创建好的单例对象
        */
        private HungrySingleClass(){};

        public final static HungrySingleClass HUNGRYOBJ=new HungrySingleClass();

        public static HungrySingleClass getInstance(){
            return HUNGRYOBJ;
        }

    }

/*该方法创建单例对象的弊端:
只要类加载,那么对象必创建,无论你是否使用它
占用了内存空间
*/