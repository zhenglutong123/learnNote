package main.CodeBlock;

/**
 * @author zlt
 * @create 2021-04-19 17:37
 *
 * 类的加载顺序
 * 父类静态变量，静态代码块顺序加载，子类的静态变量，静态代码块
 * 父类的成员，代码块顺序加载，构造器，子类的成员属性，代码块，构造器
 *
 */
public class CodeBlockTest {
    {
        System.out.println("非静态代码块执行");
    }

    public CodeBlockTest(){
        money=2;
        showMoney();
    }
    public int money=1;
    public static int mone=1;

    static {
        System.out.println("静态代码块执行");
    }

    public void showMoney(){

        System.out.println("father.money = " + this.money);
    }

    public static void showMoneyS(){

        System.out.println("静态方法 ");
    }

    public static void main(String[] args) {
        CodeBlockTest c=new CodeBlockTest();
    }
}
