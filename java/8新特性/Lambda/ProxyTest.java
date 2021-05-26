package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zlt
 * @create 2021-05-20 15:25
 */
public class ProxyTest {

    public static void main(String[] args) {
        SuperMan s=new SuperMan();
        Human p= (Human) ProxyFactory.getProxyInstance(s);
        p.eat("面包");
        System.out.println(p.getBelief());
    }
}

interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can Fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }

}

/**
 * 问题一:如何根据加载到内存中的被代理类,动态的创建一个代理类及其对象
 * 问题二:当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 * */

class ProxyFactory{
    //调用此方法,返回一个代理类的对象
    public static Object getProxyInstance(Object obj){


        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override

                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        return method.invoke(obj,args);
                    }
                });
        return o;
    }
}

class  MyInvocationHandler implements InvocationHandler{
    private Object obj;// 被代理类的对象

    public void bind(Object obj){
        this.obj=obj;
    }
    //当调用代理类的对象，调用方法A时，会自动调用Invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        return method.invoke(obj,args);
    }
}

