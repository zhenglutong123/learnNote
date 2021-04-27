/**
 * @author zlt
 * @create 2021-04-27 9:16
 *
 * 线程的生命周期
 *                               阻塞
 *            join结束                    join()
 *            sleep结束                   sleep()
 *            notify/notifyAll           wait()
 *            获取同步锁                   等待同步锁
 * 创建------>就绪------------------------->运行------------->死亡
 *              <-----失去执行权或yield--            stop
 *                                                 run执行完
 *                                                 出现错误未处理
 *说明:1.操作共享数据的代码,即为需要被同步的代码
 *    2.共享数据:多个线程共同操作的变量
 *    3.同步监视器:锁。任何一个对象都可以是锁,多个线程必须是同一把锁
 *  通过同步机制，解决线程安全问题
 *1.实现runable接口处理线程安全   2.继承thread类线程安全
 *  1.1同步代码块
 *      共享数据
 *      锁(同步监视器)
 *      synchronized(同步监视器/this){
 *
 *      }
 *  2.1同步代码块
 *      static 共享数据
 *      static 锁(同步监视器)
 *      synchronized(o/类名.class){
 *
 *      }
 *
 *  好处:解决了线程安全问题
 *  坏处:同步代码，同时只有一个线程参与，相当于单线程，降低效率，
 */
public class ThreadTest2 {
    public static void main(String[] args) {
//        Mthread2 m1=new Mthread2();
//        Thread t=new Thread(m1);
//        Thread t1=new Thread(m1);
//        Thread t2=new Thread(m1);
//        t.start();
//        t1.start();
//        t2.start();

        Mthread3 m2=new Mthread3();
        Mthread3 m3=new Mthread3();
        Mthread3 m4=new Mthread3();
        m2.start();
        m3.start();
        m4.start();
    }

}


class Mthread2 implements Runnable{
    private int i=100;
    Object o=new Object();
    @Override
    public void run() {
        while (true){
            synchronized(o){
                if (i>0){
                    System.out.println(Thread.currentThread().getName()+"卖票:"+i);
                    i--;
                }else{
                    break;
                }
            }
        }
    }
}

class Mthread3 extends Thread{
    private static int i=1000;
    @Override
    public void run() {
        while (true){
            synchronized (Mthread3.class) {
                if (i > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖票:" + i);
                    i--;
                } else {
                    break;
                }
            }
        }
    }


}
