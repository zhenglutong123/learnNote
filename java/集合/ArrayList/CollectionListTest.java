import java.util.ArrayList;
import java.util.Arrays;

/**
 * ArrayList:Object[]数组存储    查询快,增加删除慢     线程不安全       效率高
 * LinkedList:双向链表存储        增加删除快                          增删效率最高
 * Vector:Object[]数组存储                          线程安全的       效率低
 *
 * 相同点:都是有序的，不可重复的
 *
 */
public class CollectionListTest {

    public static void main(String[] args) {
        ArrayList a=new ArrayList();
        a.add(0);
    }
}

class MyList{
    //默认初始容量是10
    private static final int DEFAULT_CAPACITY = 10;
    /*** 第一次添加元素时知道该 elementData 从空的构造函数还是有参构造函数被初始化的。以便确认如何扩容。*/
    //空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};
    //空数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    //最大整数减8,集合的最大长度
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    //记录对 List 操作的次数。主要使用是在 Iterator，是防止在迭代的过程中集合被修改。
    protected transient int modCount = 0;
    //指 elementData 中实际有多少个元素，
    private int size;
    transient Object[] elementData;
    public MyList(int initialCapacity) {
        if (initialCapacity > 0) {
            //如果initialCapacity大于0,创建一个initialCapacity长度的Object数组
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            //如果为0,创建空数组
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    public MyList() {
        //空数组
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public boolean add(Object e) {
        //添加数据,进行校验确定数组需不需要扩容
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {

        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        //如果是空数组,在默认长度和minCapacity值选一个最大的
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        //如果长度大于数组长度，进行扩容
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        //当前数组长度记录下来,>>除2 ，数组扩容1.5倍
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        //如果新数组的长度减minCapacity小于0，用minCapacity长度
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        //如果新数组的长度减最大整形值大于0,进行三目预算
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
