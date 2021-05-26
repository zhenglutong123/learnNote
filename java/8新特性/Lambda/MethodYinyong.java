package ProxyTest;

import org.junit.Test;

import java.io.PrintStream;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author zlt
 * @create 2021-05-21 8:53
 */
public class MethodYinyong {

    /**对象::实例方法*/
    @Test
    public void test01(){
        Consumer c=new Consumer() {
            @Override
            public void accept(Object o) {

            }
        };

        Consumer c1=o-> System.out.println("1111"+o);
        c1.accept("ooooooooo");

        Consumer c2=System.out::println;
        c2.accept("哈哈哈");

        SuperMan s=new SuperMan();
        Supplier c3=()->s.getBelief();
        Supplier c4=s::getBelief;
    }

    /**对象::实例方法*/
    @Test
    public void test02(){
        Consumer c=new Consumer() {
            @Override
            public void accept(Object o) {

            }
        };

        Consumer c1=o-> System.out.println("1111"+o);
        c1.accept("ooooooooo");

        Consumer c2=System.out::println;
        c2.accept("哈哈哈");

        SuperMan s=new SuperMan();
        Supplier c3=()->s.getBelief();
        Supplier c4=s::getBelief;

    }
}
