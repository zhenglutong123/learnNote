package src;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zlt
 * @create 2021-05-25 14:18
 */
public class ArrayListTest<E> extends ArrayList<E>{
    /**
     * ArrayList构造方法
     * */
    @Test
    public void test01(){
        ArrayList arr=new ArrayList();
        arr.add("aaa");
        arr.add(2,"bbb");
        arr.add(3,"ccc");
        arr.add(4,"ddd");

        ArrayList arr1=new ArrayList(10);

        ArrayList arr2=new ArrayList(arr1);
    }
    @Test
    public void test02(){
        ArrayList a=new ArrayList();
        for (int i = 0; i < 5000000; i++) {
            a.add(i);
        }
        long arrayStartTime= System.currentTimeMillis();
        a.remove(50000);
        long arrayEndTime= System.currentTimeMillis();
        System.out.println(arrayEndTime - arrayStartTime);
        LinkedList b=new LinkedList();
        for (int i = 0; i < 5000000; i++) {
            b.add(i);
        }
        long linkedStartTime= System.currentTimeMillis();
        a.remove(50000);
        long linkedEndTime= System.currentTimeMillis();
        System.out.println(linkedEndTime - linkedStartTime);

    }

    public static void main(String[] args) {
//        ArrayListTest c=new ArrayListTest(10);
//        c.add(5,"6");
//        for (Object o : c) {
//            System.out.println(o);
//        }
          /**研究system.arrayCopf参数含义*/
//        ArrayList a=new ArrayList();
//        a.add("a");
//        a.add("b");
//        a.add("c");
//        a.add("d");
//        ArrayList b=new ArrayList();
//        b.add("1");
//        b.add("2");
//        b.add("3");
//        b.add("4");
//        a.addAll(1,b);
//
//        for (Object o : a) {
//            System.out.println(o);
//        }

        ArrayList a=new ArrayList();
        for (int i = 0; i < 5000000; i++) {
            a.add(i);
        }
        long arrayStartTime= System.currentTimeMillis();
        a.remove(50000);
        long arrayEndTime= System.currentTimeMillis();
        System.out.println(arrayEndTime - arrayStartTime);
        LinkedList b=new LinkedList();
        for (int i = 0; i < 5000000; i++) {
            b.add(i);
        }
        long linkedStartTime= System.currentTimeMillis();
        b.remove(50000);
        long linkedEndTime= System.currentTimeMillis();
        System.out.println(linkedEndTime - linkedStartTime);
    }
    public ArrayListTest(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final int DEFAULT_CAPACITY = 10;
    transient Object[] elementData;
    private int size;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    public void add(int index, E element) {

        ensureCapacityInternal(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }
    private void ensureExplicitCapacity(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
}
