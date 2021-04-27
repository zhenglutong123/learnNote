import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zlt
 * @create 2021-04-27 9:16
 *  方式三，LOCK锁
 */
public class ThreadTest4 {
    public static void main(String[] args) {
        Mthread6 m1=new Mthread6();
        Thread t=new Thread(m1);
        Thread t1=new Thread(m1);
        Thread t2=new Thread(m1);
        t.start();
        t1.start();
        t2.start();

    }

}


class Mthread6 implements Runnable{
    private int i=1000;
    private ReentrantLock rl=new ReentrantLock();
    @Override
    public void run() {
        while (true){
            try {
                rl.lock();
                if (i>0){
                    System.out.println(Thread.currentThread().getName()+"卖票:"+i);
                    i--;
                }else{
                    break;
                }
            }finally {
                rl.unlock();
            }


        }
    }
}


