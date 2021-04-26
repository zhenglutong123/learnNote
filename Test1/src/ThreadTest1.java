/**
 * @author zlt
 * @create 2021-04-26 16:04
 *
 * 实现runable接口创建线程
 *
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    System.out.println(Thread.currentThread().getName()+"2-"+i);
                }
            }
        }).start();

        Mthread m=new Mthread();
        Thread t=new Thread(m);

        t.setName("线程1");
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
    }
}


class Mthread implements Runnable{

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"1-"+i);
        }
    }
}
