import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author zlt
 * @create 2021-05-11 15:59
 *  File实例化
 *
 */
public class FileTest {

    @Test
    public void test1() throws IOException {
        //Linux系统和windows系统 分隔符不一样
        //File.separator
        File file=new File("d.txxt");
        //绝对路径
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(Instant.ofEpochSecond(file.lastModified()/1000));

        //遍历文件夹下目录
        String[] list = file.list();
//        for (String s : list) {
//            //文件夹名字
//            System.out.println(s);
//        }
        File[] files = file.listFiles();
//        for (File file1 : files) {
//            //绝对路径
//            System.out.println(file1);
//        }
        File f1=new File("D:\\aa\\aa.txt");

        System.out.println(f1.isDirectory());//是否是文件夹
        System.out.println(f1.exists());//是否存在
        System.out.println(f1.canExecute());//是否可以执行
        //创建文件
        f1.createNewFile();
        //删除文件
        f1.delete();
        //创建多级目录 上级目录不存在，一并创建
        f1.mkdirs();
        //创建单个目录 上级目录不存在，不创建
        f1.mkdir();
    }
}
