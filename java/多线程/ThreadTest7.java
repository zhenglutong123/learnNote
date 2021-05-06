import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zlt
 * @create 2021-04-28 10:41
 */
public class ThreadTest7 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<?> submit = executorService.submit(new ThreadPool1());
        try {
            Object o = submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

class ThreadPool1 implements Runnable{

    @Override
    public void run() {

    }
}
/**
 *
 * 1.线程的生命周期
 * 2.同步监视器，共享数据的理解
 * 3.sleep和wait的区别
 * 4.线程安全的懒汉式
 * 5.创建多线程的几种方式
 * 6.为什么要有线程的同步机制
 * 7.同步机制是有几种方式
 * 8.
 * */