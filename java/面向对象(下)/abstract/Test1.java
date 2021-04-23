/**
 *1.abstract修饰类和方法
 *2.修饰类:抽象类
 *      >此类不能实例化
 *      >抽象类中一定有构造器，便于子类实例化调用
 *      >
 *3.修饰方法:抽象方法
 *      >没有方法体
 *      >所在类一定是抽象类，抽象类中不一定有抽象方法
 *      >子类如果要实例化，必须重写父类的抽象方法，否则子类只能是抽象类
 * 4. 不能用来修饰属性，构造器，静态方法，final类，final方法，
 */

public class Test1 {
    abstract class Person{
        public  Person(){

        }

        public void speak(){
            System.out.println("父类说话");
        }
        //抽象方法不能有方法体
        public abstract void walk();
    }

    //    class Man extends Person{
//
//        //子类必须实现父类的抽象方法
//        @Override
//        public void walk() {
//
//        }
//    }
    //或者子类为抽象类
    abstract class Man extends Person{

    }
    public static void main(String[] args) {
        //抽象类不能实例化
        //Person p=new Person();
    }
}
