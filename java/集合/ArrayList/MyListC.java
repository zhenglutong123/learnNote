import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MyListC{
    Object[] elementData;
    private static final  Object[] DEFAULT_ELEMENT_DATA={};
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    MyListC(){
        this.elementData=DEFAULT_ELEMENT_DATA;
    }

    public void add(Object e){
        if(elementData==DEFAULT_ELEMENT_DATA){
            int max = Math.max(DEFAULT_CAPACITY, size + 1);
            if(max-elementData.length>0){
                int old=elementData.length;
                int newO=old+(old>>1);
                if(newO-max<0){
                    newO=max;
                }
                elementData= Arrays.copyOf(elementData,newO);
            }
        }
        elementData[size++]=e;
    }

    @Override
    public String toString() {
        return "MyListC{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyListC m=new MyListC();
        m.add(123);
        m.add(456);
        System.out.println(m);
    }

}
