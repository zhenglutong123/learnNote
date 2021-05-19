import org.junit.Test;
import org.omg.CORBA.portable.InputStream;

import java.io.*;

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
    public static void main(String[] args) {
        File f=new File("hello0.txt");
    }
    @Test
    public void test01() throws IOException {
        File f=new File("hello.txt");
//        f.createNewFile();
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getPath());
        //输出流,字符流，节点流
        FileWriter fw=new FileWriter("f");
        fw.write("helloFile3");
        fw.close();
        //字符流，节点流，输入流
        FileReader fr=new FileReader(f);
        //int read = fr.read();
//        while (read!=-1){
//            System.out.print((char) read);
//            read = fr.read();
//        }
        int i;
        //每次只读一个
//        while ((i=fr.read())!=-1){
//            System.out.print((char) i);
//        }
        //每次读5个
        char[] c=new char[5];
        while ((i=fr.read(c))!=-1){
            for (int j=0;j<i;j++){
                System.out.println(c[j]);
            }
        }
        fr.close();
    }

    @Test
    public void test02() throws IOException{
        FileInputStream fis=new FileInputStream("许嵩 - 断桥残雪.mp3");
        FileOutputStream fot=new FileOutputStream("断桥残血.mp3");

        int i;
        byte[] b=new byte[10];
        while ((i=fis.read(b))!=-1){
            fot.write(b,0,b.length);
        }

        fis.close();
        fot.close();
    }

    @Test
    public void test03() throws IOException{
        FileInputStream fis=new FileInputStream("许嵩 - 断桥残雪.mp3");
        FileOutputStream fot=new FileOutputStream("断桥残血.mp3");

        int i;
        byte[] b=new byte[10];
        while ((i=fis.read(b))!=-1){
            fot.write(b,0,b.length);
        }

        fis.close();
        fot.close();
    }

    /**序列化
     * 类实现Serializable接口
     * 定义全局常量  serialVersionUID
     * 保证其内部属性必须是可序列化的,不能序列化static和transient修饰的成员变量
     * */
    @Test
    public void test04() throws IOException{
        ObjectOutputStream fis= null;
        ObjectInputStream fot= null;
        try {
            fis = new ObjectOutputStream(new FileOutputStream("11.aa"));
            fis.writeObject("嗷嗷嗷");
            fis.flush();
            fot = new ObjectInputStream(new FileInputStream("11.aa"));
            Object o = fot.readObject();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            fis.close();
            fot.close();
        }

    }
    @Test
    public void test05() throws IOException{
        BufferedInputStream bi=new BufferedInputStream(System.in);
        InputStreamReader ir=new InputStreamReader(bi);
    }
}
