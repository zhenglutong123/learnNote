/**
 * @author zlt
 * @create 2021-04-22 16:49
 *
 * 1.接口使用interface来定义
 * 2.java中，接口和类是并列的
 * 3.定义接口，接口中的成员
 *      3.1 JDK7及以前
 *          只能定义全局常量和抽象方法
 *          >全局常量:public static final
 *          >抽象方法:public abstract
 *      3.2 JDK8
 *          除了全局常量和抽象方法，还可以定义静态方法、默认方法
 *
 * 4.接口中不能定义构造器
 * 5.接口通过让类实现的方式来使用
 *      5.1 实现类覆盖了接口中的所有抽象方法，就可以实例化，如果没有实现，仍为抽象类
 * 6.java类可以实现多个接口
 * 7.接口和接口之间可以多继承
 */
public class IntefaceTest {
}

interface Flyable{
    //全局常量
    public static final int MAX_SPEED=7900;

    void fly();

}

interface attackable{

}

//abstract  class Bird implements Flyable{
class Bird implements Flyable{
    @Override
    public void fly() {

    }
}


/*************************/
interface aa{

}

interface bb{

}
interface cc extends aa,bb{

}