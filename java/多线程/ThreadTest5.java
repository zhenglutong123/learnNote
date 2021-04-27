/**
 * @author zlt
 * @create 2021-04-27 16:27
 *
 * 生产者-消费者
 */
public class ThreadTest5 {
    public static void main(String[] args) {
        Cler c=new Cler();
        Producer p1=new Producer(c);
        Customer c1=new Customer(c);
        p1.start();
        c1.start();
    }
}

class Cler{

    int i=0;
    public synchronized void xiaofei() {
        if (i<20){
            i++;
            System.out.println(Thread.currentThread().getName()+":生产"+i);
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void shengc() {
        if (i>0){
            System.out.println(Thread.currentThread().getName()+":消费"+i);
            i--;
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Cler cler;
    public Producer(Cler cler){
        this.cler=cler;
    }

    @Override
    public void run() {
        while (true){
            cler.shengc();
        }

    }
}

class Customer extends Thread{
    private Cler cler;
    public Customer(Cler cler){
        this.cler=cler;
    }

    @Override
    public void run() {
        while (true) {
            cler.xiaofei();
        }
    }
}