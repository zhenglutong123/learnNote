import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zlt
 * @create 2021-05-14 16:07
 *
 * IO基本概念
 * 1.操作数据单位:字节流，字符流
 * 2.数据的流向:输入流，输出流
 * 3.流的角色:节点流，处理流
 */
public class IO {
    @Test
    public void test01() throws IOException {
        File f=new File("hello.txt");
        f.createNewFile();
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getPath());
        //输出流,字符流，节点流
        FileWriter fw=new FileWriter(f);
        fw.write("helloFile");
        //字符流，节点流，输入流
        FileReader fr=new FileReader(f);
        int read = fr.read();
        while (read!=-1){
            System.out.print((char) read);
            read = fr.read();
        }

        fr.close();
        fw.close();


    }
}
