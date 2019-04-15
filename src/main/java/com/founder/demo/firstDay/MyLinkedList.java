package com.founder.demo.firstDay;


public class MyLinkedList<E> {
    /**
     * 定义链表节点
     * 私有的静态内部类（访问安全）
     */
    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
    transient  private int size;

    transient private Node<E> first;

    transient private Node<E> last;
    public int size() {
        return size;
    }

    /**
     * 1、第一个插入方法add的实现
     * @param element
     * @return
     */
    public boolean add(E element) {
        addAtLast(element);
        return true;
    }
    private void addAtLast(E element) {
        Node<E> l = last;
        Node<E> node = new Node<E>(element, null, l);
        last = node;
        if (l == null) {
            first = node;
        } else {
            l.next = node;
        }
        size++;
    }
    /**
     * 2、第二个插入add的实现（add重载）
     * 在指定的链表下标，插入元素
     */
    public void add(int index, E element) {
//        checkRangeForAdd(index);
        if (index == size) {
            addAtLast(element);
        } else {
            Node<E> l = node(index);
            addBeforeNode(element, l);
        }
    }
    private Node<E> node(int index) {
        if (index < (size << 1)) {
            Node<E> cursor = first;
            for (int i = 0; i < index; i++) {
                cursor = cursor.next;
            }
            return cursor;
        } else {
            Node<E> cursor = last;
            for (int i = size - 1; i > index; i--) {
                cursor = cursor.prev;
            }
            return cursor;
        }
    }
    private void addBeforeNode(E element, Node<E> specifiedNode) {
        Node<E> preNode = specifiedNode.prev;
        Node<E> newNode = new Node<>(element, specifiedNode, preNode);
        if (preNode == null) {
            first = newNode;
        } else {
            preNode.next = newNode;
        }
        specifiedNode.prev = newNode;
        size++;
    }

    /**
     * 获取制定位置元素
     * @param index
     * @return
     */
    public E get(int index) {
        checkRange(index);
        return node(index).item;
    }

    /**
     *
     * checkRange检查index是否不在范围内。
     */
    private void checkRange(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("指定index超过界限");
        }
    }

    /**
     *indexOf(Object o)用来得到指定元素的下标。
     */
    public int indexOf(Object element) {
        Node<E> cursor = first;
        int count = 0;
        while (cursor != null) {
            if (element != null) {
                if (element.equals(cursor.item)) {
                    return count;
                }
            }else{
                if (cursor.item == null) {
                    return count;
                }
            }
            count ++;
            cursor = cursor.next;
        }
        return -1;
    }
    /**
     * remove方法与add方法一样，同样有两个重载的方法，remove(Object o)与remove(int index)
     */
    public E remove(int index) {
        checkRange(index);
        return deleteLink(index);
    }

    /**
     *
     * remove另一个重载方法remove(Object o)，在实现了indexOf和deleteLink方法之后，就非常简单。
     */

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0){
            return false;
        }
        deleteLink(index);
        return true;
    }
    /**
     *
     *deleteLink是将该index所对应的节点的链接删除的方法，其代码如下：
     *
     */
    private E deleteLink(int index) {
        Node<E> l = node(index);
        E item = l.item;
        Node<E> prevNode = l.prev;
        Node<E> nextNode = l.next;

        if (prevNode == null) {
            first = nextNode;
        }else{
            prevNode.next = nextNode;
            l.next = null;
        }

        if (nextNode == null) {
            last = prevNode;
        }else{
            nextNode.prev = prevNode;
            l.prev = null;
        }
        size--;
        l.item = null;
        return item;
    }
}
