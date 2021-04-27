/**
 * @author zlt
 * @create 2021-04-27 9:16
 *
 */
public class ThreadTest3 {
    public static void main(String[] args) {
//        Mthread4 m1=new Mthread4();
//        Thread t=new Thread(m1);
//        Thread t1=new Thread(m1);
//        Thread t2=new Thread(m1);
//        t.start();
//        t1.start();
//        t2.start();

        Mthread5 m2=new Mthread5();
        Mthread5 m3=new Mthread5();
        Mthread5 m4=new Mthread5();
        m2.start();
        m3.start();
        m4.start();
    }

}


class Mthread4 implements Runnable{
    private int i=1000;
    Object o=new Object();
    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private synchronized void show(){
        if (i>0){
            System.out.println(Thread.currentThread().getName()+"卖票:"+i);
            i--;
        }
    }
}

class Mthread5 extends Thread{
    private static int i=1000;
    @Override
    public void run() {
        while (true){
            show();
        }
    }


    private static synchronized void show(){
        if (i>0){
            System.out.println(Thread.currentThread().getName()+"卖票:"+i);
            i--;
        }
    }
}
