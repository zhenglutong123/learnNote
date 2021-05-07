/**
 * @author zlt
 * @create 2021-05-07 15:30
 */
public class ZidingyiEnum {
    private final String name;
    private final String age;

    private ZidingyiEnum(String name,String age){
        this.age=age;
        this.name=name;
    }

    public static final ZidingyiEnum zs=new ZidingyiEnum("张三","18");
    public static final ZidingyiEnum ls=new ZidingyiEnum("李四","18");
    public static final ZidingyiEnum ww=new ZidingyiEnum("王五","18");

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ZidingyiEnum{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ZidingyiEnum zs = ZidingyiEnum.zs;
        System.out.println(zs.getName());
        System.out.println(zs);
    }
}
