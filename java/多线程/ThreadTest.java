/**
 * @author zlt
 * @create 2021-04-26 11:02
 * 1.基本概念，程序，进程，线程‘
 * 2.线程的创建方式
 * 3.线程的生命周期
 * 4.线程的同步
 * 5.线程的通信
 * 6.JDK5新增的线程创建方式
 *
 *
 *
 * 程序:用编程语言编写的一组指令的集合，一组静态的代码
 * 进程:正在运行的一个程序,是动态的,有生命周期
 * 线程:是进程的实际运行单位
 *      1.每个线程拥有独立的 VM栈和程序计数器
 *      2.所有线程共享方法区和堆
 *
 * 创建线程的方式
 *      1.继承thread类,重写run方法,调用start()执行
 *      2.实现runable接口,重写run方法,创建对象，放到thread对象里，thread.start执行线程
 *  开发中:优先使用runable接口
 *  1.实现的类没有单继承的局限性
 *  2.实现的方式更适合处理多个线程有共享数据的情况
 * 常用的方法
 * run():重写的方法,要执行的操作写在方法体里
 * start:开启当前对象线程，执行run
 * currentThread:返回执行当前代码的线程
 * getName:获取当前线程的名字
 * setName:设置当前线程的名字
 * yield:释放当前cpu的执行权
 * join:在线程a中调用线程B的Join,线程a进入阻塞状态,当线程B执行完后，线程A才执行
 * stop:过时，强制结束当前线程
 * sleep:让当前线程进入睡眠状态
 * isAlive:判断当前线程是否存活
 *
 * 线程优先级
 *  设置
 *  setPriority()
 *  获取
 *  getPriority()
 *
 *  高优先级线程抢占cpu执行权，只是高概率执行高优先级,不意味着先执行完高优先级
 *
 *
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread1 t1=new Thread1();
        t1.setName("线程1");
        t1.start();
        for (int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println(Thread.currentThread().getName()+"******"+i);
            }
            if(i==21){
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

//    public static void main(String[] args) {
//        Make m=new Make();
//        m.start();
//        for (int i=0;i<1000;i++){
//            if(i%2!=0){
//                System.out.println(i+"*****main***********");
//            }
//        }
//    }
}


class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+"******"+i);
            }

            if(i==20){
                this.yield();
            }
        }
    }
}




//class Make extends Thread{
//    @Override
//    public void run() {
//        for (int i=0;i<1000;i++){
//            if(i%2==0){
//                System.out.println(i);
//            }
//        }
//    }
//}