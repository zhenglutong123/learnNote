import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author zlt
 * @create 2021-05-19 17:04
 *
 * 实现了dataOutput,DataInput接口
 * 可以做输出流，也可以做输入流
 * 文件存在，对原有文件内容从头开始覆盖
 */
public class RandomAccessFileTest {

    @Test
    public void test01() throws IOException {
        RandomAccessFile ra=new RandomAccessFile(new File("hello1.txt"),"rw");
        //ra.write("ABCDEFG".getBytes(StandardCharsets.UTF_8));

        RandomAccessFile raf=new RandomAccessFile(new File("hello2.txt"),"rw");
        int i;
        byte[] b=new byte[5];
        while ((i=ra.read(b))!=-1){
            raf.write(b,0,i);
        }
        ra.close();
        raf.close();
    }

    @Test
    public void test02() throws IOException {
        RandomAccessFile ra=new RandomAccessFile(new File("hello1.txt"),"rw");
        ra.write("ABCDEFG".getBytes(StandardCharsets.UTF_8));

        RandomAccessFile raf=new RandomAccessFile(new File("hello1.txt"),"r");
        int i;
        byte[] b=new byte[5];
        while ((i=raf.read(b))!=-1){
            for (byte b1 : b) {
                System.out.println(b1);
            }

        }
        ra.close();
        raf.close();
    }
}
