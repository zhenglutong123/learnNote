/**
 * @author zlt
 * @create 2021-04-23 9:23
 * 内部类
 * 1.在类A中声明B类   A外部类，B内部类
 * 2.内部类分为 成员内部类(静态,非静态)   局部内部类
 * 3.成员内部类，4种权限修饰符都可以用，其他和普通类一样
 *
 *4.局部内部类的方法中，调用所在方法的局部变量，局部变量要求为final的
 *
 *
 */
public class Test1 {
    public static void main(String[] args) {
        //实例化内部类
        F.G fg=new F.G();
        fg.eat();

        F f=new F();
        F.E fe=f.new E();

    }

}
class F{
    String name;
    public void eat(){
        System.out.println("吃东西");
    }
    //局部内部类
    public F(){
        class A{

        }
    }

    {
        class B{

        }
    }

    static {
        class C{

        }
    }

    public void Hao(){
        class D{

        }
    }

    //成员内部类 4种权限修饰符都可以用
    class E{
        String name;
        int age;

        public void run(){
            F.this.eat();//调用外部类的方法
            F.this.name="网三";
        }
    }

    static class G{
        public void eat(){
            System.out.println("G吃");
        }
    }
}