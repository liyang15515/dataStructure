package com.founder.demo.secondDay;

/**
 * 链式队列实现
 * 同理，基于LinkedList也可实现队列
 */
public class MyQueue3 {
    //头节点
    private Node front;
    //尾节点
    private Node back;
    //数据量
    private Integer size = 0;

    /**
     *
     * 出队操作
     */
    public Integer deQueue(){

        if(front == null) {
            return front.data;
        }
        else {
            Integer data = front.data;
            Node fNode = front;
            front = fNode.next;
            //将头节点指向null，等待垃圾回收器回收
            fNode = null;
            size--;
            return data;
        }
    }
    /**
     * 入队操作
     */
    public void enQueue(Integer data) {
        Node n = new Node(data);

        if(front == null) {
            front = n;
            back = front;
        }
        else {
            back.next = n;
            //非循环队列
            back = n;

            //循环队列
            //back.next = front
        }
        size++;
    }
    /**
     * 清空队列
     */
    public void clean() {
        Node fNode  = front;
        while(fNode != null) {
            front = fNode.next;
            fNode = null;
            fNode = front;
            size--;
        }
        back = null;
    }
    public String toString() {
        String str = "The Queue data is : ";
        Node fNode  = front;
        while(fNode != null) {
            str += fNode.data + "  ";
            fNode  = fNode.next;
        }
        str += "\t" + "the size is :" + size;
        return str;
    }
}
class Node{
    public Integer data;//data:节点数据
    public Node next;//next：指向下一个节点
    public Node(Integer data) {
        super();
        this.data = data;
    }
}