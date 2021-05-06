import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author zlt
 * @create 2021-05-06 11:12
 *
 * 1.string内部定义了final char[] value用于存储字符串数据
 * 2.通过字面量的方式给一个字符串赋值，此时字符串值声明在字符串常量池中
 * 3.字符串常量池中是不会存储相同内容的字符串的
 * 4.不可变性
 *      4.1：对一个字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
 *      4.2: 当对现有字符串进行连接操作时，也需要进行重新指定内存区域赋值，不能使用原有的value进行赋值
 *
 *
 */
public class StringClassTest {
    public static void main(String[] args) {
        String s="cABCab123";
        byte[] bytes = s.getBytes();
        Arrays.toString(bytes);
        char c = s.charAt(2);
        System.out.println(c);
        StringBuffer s1=new StringBuffer();

        Integer a=5;

        int ab = s.indexOf("ab");
        System.out.println(ab);
    }
    @Test
    public void test1(){
        String a="abwewrabrtabeetwabppsab";
        String b="ab";
        int i=0;
        int index;

        while ((index=a.indexOf(b))!=-1){
            i++;
            a=a.substring(index+b.length());
        }
        System.out.println(i);


    }
}
