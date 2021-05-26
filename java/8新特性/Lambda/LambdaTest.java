package ProxyTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author zlt
 * @create 2021-05-20 17:30
 *
 * ->左边:接口中抽象方法的参数列表
 * ->右边:重写抽象方法的方法体
 */
public class LambdaTest {
    @Test
    public void test01(){
        Runnable r=new Runnable() {
            @Override
            public void run() {
                System.out.println("无参,无返回值");
            }
        };
        r.run();
        Runnable r1=()-> System.out.println("无参,无返回值lambda");
        r1.run();
    }

    @Test
    public void test02(){
        Consumer r=new Consumer() {

            @Override
            public void accept(Object o) {
                System.out.println("有参,无返回值");
            }
        };
        r.accept(new Object());
        Consumer r1=(Object o)-> System.out.println("有参,无返回值lambda");
        r1.accept(new Object());
    }

    /**类型推断*/
    @Test
    public void test03(){
        Consumer r=new Consumer() {

            @Override
            public void accept(Object o) {
                System.out.println("有参,无返回值");
            }
        };
        r.accept(new Object());
        Consumer r1=(o)-> System.out.println("有参,无返回值lambda");
        r1.accept(new Object());
    }

    /**方法一个参数 小括号可以省*/
    @Test
    public void test4(){
        Consumer r=new Consumer() {

            @Override
            public void accept(Object o) {
                System.out.println("有参,无返回值");
            }
        };
        r.accept(new Object());
        Consumer r1=o-> System.out.println("有参,无返回值lambda");
        r1.accept(new Object());
    }

    /**1行执行语句可以不写大括号,多行得写*/
    @Test
    public void test5(){
        Comparator<Integer> c1=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println("****************");
        Comparator<Integer> c2=(o1,o2)->Integer.compare(o1,o2);
        System.out.println("****************");
        Comparator<Integer> c3=(o1,o2)->{
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
    }
}



