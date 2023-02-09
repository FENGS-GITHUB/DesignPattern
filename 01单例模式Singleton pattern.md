# 单例模式

**思想:**

- 需求要求某个类只创建一个实例,一个实例可重复使用,不多次创建,节省了内存空间.

**如:**

- 工厂:创建一个工厂就能够一直通过这个工厂创建对象
- 管理器:一个管理器对象可重复使用...
- ......

## 实例

### 饿汉式

#### 饿汉式思想:

饿汉式单例模式,就是在类加载的时候就直接创建对象,无论你是否需要.

缺点:占用过多内存空间.

```java
public class HungrySingleClass{
	private HungrySingleClass(){};
	
    public final static HungrySingleClass HUNGRYOBJ=new HungrySingleClass();
	
    public static HungrySingleClass getInstance(){
		return HUNGRYOBJ;
	}

}
```

### 懒汉式:

#### 懒汉式思想:

懒汉式单例模式

这种单例模式是一种需要才创建的单例模式

该类对象不为空,那么创建该实例对象

判断对象为非空,那么该实例对象就不会创建

```java

public class LazySingle{

	private LazySingle(){	}

	private LazySingle lazyObj;

	public static LazySingle getInstance(){
		
        //多线程情况下问题处:
        if (lazyObj==null) {
			lazyObj = new LazySingle();
		}
		//多线程情况下问题处
        
		return lazyObj;
	} 
}
```

#### 缺点:

> 懒汉式在多线程情况下,可能会存在问题:
>
> 当线程1通过if判断后还未来得及创建对象
>
> 此时线程2仍能够通过判断
>
> 这样就导致创建了两个实例对象

#### 解决方法:

在创建对象的过程中加锁,让判断和创建这两个过程只能由一个线程执行

```java
package _02lazy;
public class LazySingleLock{
    private LazySingleLock(){	}

    public static LazySingleLock LazyObj;

    public static LazySingleLock getInstance(){

        if (LazyObj==null) {
            /*
            此处加锁后,假设由两个线程执行到该代码
            改代码加锁后只能有一个线程执行
            执行完毕后,另一个线程进入经过两个过程
            	1判断是否为空?为空直接跳出
                2不为空创建对象(已经创建过了,该语句不执行)
            */
            synchronized(LazySingleLock.class){
                if (LazyObj==null) {
                    LazyObj=new LazySingleLock();
                }

            }
        }
        return LazyObj;
    }

}
```

# 反射能够破坏单例模式

反射能够获取私有的构造器对象,所以反射可以破坏单例模式只能够创建要给对象的特性.

为了解决这种问题,可以在私有构造器中进行一次加锁判断.

```java
package _02lazy;
public class LazySingleLock{
    private LazySingleLock(){	
            synchronized(LazySingleLock.class){
                if (LazyObj==null) {
                    LazyObj=new LazySingleLock();
                }

            }
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
```

