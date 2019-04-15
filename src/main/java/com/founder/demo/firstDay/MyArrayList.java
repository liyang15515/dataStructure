package com.founder.demo.firstDay;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 *
 * @author yanglee
 */
public class MyArrayList<E> implements Iterable<E> {
    private int size;//实际元素个数（指的是elementData 中实际有多少个元素）
    private Object[] elementData;//

    private static final int DEFAULT_CAPACITY = 10;//默认的数组容量大小常量
    protected transient int modCount = 0;//记录对 List 操作的次数。主要使用是在 Iterator，是防止在迭代的过程中集合被修改。

    private E  elementData(int index){
        E e = ((E) elementData[index]);
        return e;
    }
    /**
     *下面两个变量是用在构造函数里面的
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 1,无惨构造函数
     * Constructs an empty list with an initial capacity of ten.
     * 注意：注释是说构造一个容量大小为 10 的空的 list 集合，
     * 但构造函数了只是给 elementData 赋值了一个空的数组，
     * 其实是在第一次添加元素时容量扩大至 10 的。
     */
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 2,有参构造函数
     * 构造一个初始容量大小为 initialCapacity 的 ArrayList
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }
    /**
     *     3,
     *     使用指定 Collection 来构造 ArrayList 的构造函数
     */
    public MyArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (elementData.getClass() != Object[].class)
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            // replace with empty array.
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     *     add 操作
     */
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     *
     * 每次添加元素到集合中时都会先确认下集合容量大小。然后将 size 自增 1。
     * ensureCapacityInternal 函数中
     * 判断如果 elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA 就取 DEFAULT_CAPACITY 和 minCapacity 的最大值也就是 10。
     * 这就是 EMPTY_ELEMENTDATA 与 DEFAULTCAPACITY_EMPTY_ELEMENTDATA 的区别所在。
     * 同时也验证了上面的说法：使用无惨构造函数时是在第一次添加元素时初始化容量为 10 的。
     * ensureExplicitCapacity 中对 modCount 自增 1，记录操作次数，
     * 然后如果 minCapacity 大于 elementData 的长度，则对集合进行扩容。
     * 显然第一次添加元素时 elementData 的长度为零。那我们来看看 grow 函数。
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
//        if (newCapacity - MAX_ARRAY_SIZE > 0)
//            newCapacity = hugeCapacity(minCapacity);先注释掉，这种事情几乎不会发生
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     *
     * 很简单明了的一个函数，默认将扩容至原来容量的 1.5 倍。但是扩容之后也不一定适用，有可能太小，有可能太大。
     * 所以才会有下面两个 if 判断。如果1.5倍太小的话，则将我们所需的容量大小赋值给newCapacity，
     * 如果1.5倍太大或者我们需要的容量太大，那就直接拿
     * newCapacity = (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE 来扩容。
     * 然后将原数组中的数据复制到大小为 newCapacity 的新数组中，并将新数组赋值给 elementData
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }
    public void add(int index, E element) {
//        rangeCheckForAdd(index);先注释掉，这是用来检查这个index是否已经占用
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  // Increments modCount
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;
    }
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);

        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  // Increments modCount

        int numMoved = size - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew, numMoved);

        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }

    /**
     *
     *     当我们调用 remove(int index) 时，首先会检查 index 是否合法，然后再判断要删除的元素是否位于数组的最后一个位置。
     *     如果 index 不是最后一个，就再次调用 System.arraycopy() 方法拷贝数组。
     *     说白了就是将从 index + 1 开始向后所有的元素都向前挪一个位置。然后将数组的最后一个位置空，size - 1。
     *     如果 index 是最后一个元素那么就直接将数组的最后一个位置空，size - 1即可。
     *     当我们调用 remove(Object o) 时，会把 o 分为是否为空来分别处理。
     *     然后对数组做遍历，找到第一个与 o 对应的下标 index，
     *     然后调用 fastRemove 方法，删除下标为 index 的元素。
     *     其实仔细观察 fastRemove(int index) 方法和 remove(int index) 方法基本全部相同。
     */
    public E remove(int index) {
//        rangeCheck(index);
        modCount++;
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index, numMoved);
        elementData[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    public boolean remove(Object o) {
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }

    private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }



    //get操作
    public E get(int index) {
//        rangeCheck(index);
        return elementData(index);
    }
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }
}
