# 工厂设计模式

## 前言:

工厂,一个产生对象的实例,它的功能就是创造用户所需的对象,用户无需通过`new ClassName()`来创造对象.

工厂是一个单例对象,只需要一个就行,不需要也不能重复创建.

面向接口:接口可以看作是一个限制条件,定义需要操作一个接口的实现类对象,其接口的所有实现类都可以被使用.

> 以参数为例:
>
> 一个功能需要的参数为实现"动物"接口的实现类,那么所有"动物接口的实现类"都可以满足需求.
>
> 如果使用面向接口编程,所需参数可能是某个具体的类,那么能够满足该参数的类只有一个.
>
> 这两种结果就是:"低耦合度"和"高耦合度",一个是可以对应多个符合接口的类,另一个是只能够对应单个类.

## 要求

- 开闭原则:能够添加,不能修改
- 依赖倒转:面向接口编程
- 迪米特里法则:避免跨友通信

## 简单工厂/静态工厂

工厂就是一个单例对象,它可以通过调用方法来创建对象.

该设计模式无法实现开闭原则.

### 实现

```java
//工厂类:Factory
package _01SimpleFactory;
public class Factory{
    private Factory(){};
    public final static Factory factory=new Factory();
    public static Factory getInstance(){
        return factory;
    }
//饿汉式单例模式的工厂类
    
    public static Product getProduct(String ProductName){
        if(ProductName.equals("ProductA")){
            return new ProductA();
        }else if (ProductName.equals("ProductB")){
            return new ProductB();
        }else{
            return  null;
        }
    }
//此时只能够生产两种产品,如果要生产新产品,就要修改工厂类代码
}

//产品接口,用于解耦合,将返回值或者参数设定为接口,可返回或者传参它的所有实现类
package _01SimpleFactory;

public interface Product {
    public void use();
}

//产品A和产品B
package _01SimpleFactory;
public class ProductA implements Product{
    @Override
    public void use() {
        System.out.println("使用了产品ProductA");
    }
}

package _01SimpleFactory;
public class ProductB implements Product{
    @Override
    public void use() {
        System.out.println("这是一个产品ProductB");
    }
}
```

### 弊端

这种方式创建工厂对象,要想让工厂生成新的产品,就必须要修改工厂代码,违背了开闭原则,所以不可取.

### 对策

为了遵循开闭原则,可以将工厂再次抽取加层,也就是说要想生成新产品,就要创建一个新的该产品工厂.

举例来说:

一个工厂只能够创建一种对象,如果要想添加对象,就要创建一个新的工厂,并且该新工厂只能生成该种对象.

具体实现就是,将工厂再次抽取出接口,这时就有了两层接口:工厂层接口和产品接口.

工厂接口定义了工厂类型,产品接口定义了该工厂的产品.

以上引出一个新的工厂模式:工厂方法.

## 工厂方法

工厂方法是将工厂再次抽取出接口,在这个工厂接口中定义了一个方法:创造实现产品接口的产品.

主要几个元素:

- 工厂接口Factory:其抽象方法:创建为Product接口的产品,确定工厂接口的实现类只能够创建Product接口的实例.也就是说,Factory依赖于Product.
- 产品接口Product:其抽象方法:确定了该接口的实现类能够怎么用,确定了多个接口的
- 工厂实现类:确定了生产哪种产品的工厂对象.
- 产品实现类:确定了具体产品对象.

### 实现:

```java
//工厂接口 依赖于产品接口
package _02FctoryMethod;
public interface Factory {
    public Product getProduct();
}
//产品接口
package _02FctoryMethod;
public interface Product {
    public void use();
}
//产品ProductA
package _02FctoryMethod;

public class ProductA implements Product{

    @Override
    public void use() {
        System.out.println("执行了ProductA的功能");
    }
}
//生产产品A的工厂,依赖于产品ProductA
package _02FctoryMethod;

public class FactoryA implements Factory{
    //饿汉式单例对象创建模式
    private FactoryA(){};
    public final static Factory factory=new FactoryA();
    public static Factory getInstance(){
        return factory;
    }  
    //规定FactoryA工厂只能创建ProductA产品
    @Override
    public Product getProduct() {
        return new ProductA();
    }

}
```

如果想要新增产品B生产线:

1. 创建产品ProductB的类模板,作为FactroyB的依赖类
2. 创建FactoryB类

```java
//创建产品类ProductB
package _02FctoryMethod;

public class ProductB implements Product{
    @Override
    public void use() {
        System.out.println("使用了ProductB产品");
    }
}

//创建工厂类FactoryB
package _02FctoryMethod;

public class FactoryB implements Factory{

    private FactoryB(){};
    public final static Factory factory=new FactoryB();
    public static Factory getInstance(){
        return factory;
    }

    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
```

### 总结:

接口2个:工厂接口,依赖的产品接口.

单例对象:2个工厂对象;

一般对象:工厂创建的产品对象;

增加新产品工厂只需要新添加一个实现产品接口的新产品类.再新建一个工厂接口的实现类来创建这个新产品类即可.

## 抽象工厂

所需的产品存在一个等级与族的关系时,采用的模式为抽象工厂模式.例如:

> 等级:产品类型:Phone VideoPlayer
>
> 族:产品品牌: A B
>
> 那么要求工厂能够产出如下对象:
>
> - A品牌Phone
> - B品牌Phone
> - A品牌VideoPlayer
> - B品牌VideoPlayer

该设计模式目的是创建更少的工厂对象.

相对于工厂方法一个工厂只能够生产一种产品,抽象工厂一个工厂能生产多种产品.

工厂的数量也从四个变为了两个.

如果抽取的工厂接口为产品抽取,那么一个工厂就能够生产不同品牌的同种产品.

工厂对象就有两种:A品牌工厂和B品牌工厂.

### 实现:

```java
package _03AbstractFactory;
//工厂接口,定义了工厂能做什么
public interface Factory {
    public Phone createPhone();
    public VideoPlayer creatVideoPlayer();
}
```



 