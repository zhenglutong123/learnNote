/**
 * 1.final:最终的
 * 可以修饰 类    方法
 * 不能被  继承   重写
 *
 * 2.修饰属性  常量，
 *      2.1值不能被修改
 *      2.2赋值的位置有:显示初始化，代码块，构造器
 *
 */
public class FinalTest {
    final int right=0;
    final int width;
    final int height;
    final int left;
    {
        width=3;
    }

    public FinalTest(){
        height=4;
    }

    public FinalTest(){
        left=4;
    }


}