/**
 * 1.单例设计模式
 *      确保类只有一个对象实例
 * 2.饿汉和懒汉
 * 3.
 */

public class SingletonTest {
    public static void main(String[] args) {
        Bank b=Bank.getInstance();
        Bank b1=Bank.getInstance();
        System.out.println(b1==b);
    }

}
//饿汉式
class Bank{
    //私有化构造器
    private Bank(){

    }
    private static Bank instance=new Bank();

    public static Bank getInstance(){
        return instance;
    }
}

//懒汉式
class BankSon{
    //私有化构造器
    private BankSon(){

    }
    private static BankSon instance=null;

    public static BankSon getInstance(){
        if(instance==null){
            instance=new BankSon();
        }
        return instance;
    }
}