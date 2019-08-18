package com.founder.algorithm.second;

/**
 * @Author yanglee
 * @Date 2019-08-04 20:47
 * @Description TODO  2、选择排序之堆排序
 * @Version 1.0
 **/
public class HeapSort {
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] array = { 19, 8, 27, 6, 35, 14, 3, 12, 1, 0, 9, 10, 7 };

        System.out.println("Before heap:");
        heapSort.printArray(array);

        heapSort.heapSort(array);

        System.out.println("After heap sort:");
        heapSort.printArray(array);
    }

    public void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        buildMaxHeap(array);//建立最大堆
        // 上述逻辑，建堆结束
        // 下面，开始排序逻辑
        for (int i = array.length - 1; i >= 1; i--) {
            //最大的在0位置，那么开始沉降，这样每交换一次最大的值就丢到最后了
            exchangeElements(array, 0, i);
            //继续获取0位置最大值
            // 元素交换之后，毫无疑问，最后一个元素无需再考虑排序问题了。
            // 接下来我们需要排序的，就是已经去掉了部分元素的堆了，这也是为什么此方法放在循环里的原因
            // 而这里，实质上是自上而下，自左向右进行调整的
            maxHeap(array, i, 0);
        }
    }

    //(2)		//建立最大堆
    private void buildMaxHeap(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        // 按照完全二叉树的特点，从最后一个非叶子节点开始，对于整棵树进行大根堆的调整
        // 也就是说，是按照自下而上，每一层都是自右向左来进行调整的
        // 注意，这里元素的索引是从0开始的
        // 另一件需要注意的事情，这里的建堆，是用堆调整的方式来做的
        // 堆调整的逻辑在建堆和后续排序过程中复用的
        int half = (array.length-1) / 2;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    /**@Author yanglee
    * @Description: TODO 这里，是整个堆排序最关键的地方，正是因为把这个方法抽取出来，才更好理解了堆排序的精髓，
                            会尽可能仔细理解
     * @Param [array, heapSize, index]
    * @Return void
    * @Date 2019-08-13 18:56 
    */
    private void maxHeap(int[] array, int heapSize, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < heapSize && array[left] > array[index]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (index != largest) {
            exchangeElements(array, index, largest);

            maxHeap(array, heapSize, largest);
        }
    }

    //（3）
    public void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    // 元素交换
    // 说是交换，其实质就是把大顶堆的根元素，放到数组的最后；
    // 换句话说，就是每一次的堆调整之后，都会有一个元素到达自己的最终位置
    public void exchangeElements(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
