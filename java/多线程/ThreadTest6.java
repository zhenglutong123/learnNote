import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author zlt
 * @create 2021-04-27 17:20.
 * 第三种线程创建方式
 */
public class ThreadTest6 {
    public static void main(String[] args) {
        Num n=new Num();
        FutureTask f=new FutureTask(n);
        Thread t1=new Thread(f);
        t1.start();
        try {
            Object o = f.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class Num implements Callable{
    int i=0;
    @Override
    public Object call() throws Exception {
        for (int j=0;j<100;j++){
            i=j;
        }
        return i;
    }
}
