/**
 * @author zlt
 * @create 2021-05-07 15:40
 * 自动继承enum抽象类
 * SUMMER new对象的对象名
 */
interface A{
    public  abstract void show();
}

public enum EnumTest implements A{
    SUMMER{
        @Override
        public void show() {

        }
    };
    private int i=0;
    EnumTest(){

    }
    public static final EnumTest winner=new EnumTest();
    public static void main(String[] args) {
        EnumTest summer = EnumTest.SUMMER;
        EnumTest.winner;
        System.out.println(summer);
        System.out.println(EnumTest.class.getSuperclass());
    }
}
