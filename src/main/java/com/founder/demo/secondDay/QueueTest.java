package com.founder.demo.secondDay;

import java.util.Queue;

/**
 * Java队列就是"单向链表"
 */
public class QueueTest {

    public static void main(String[] args){

        //测试队列
/*        System.out.println("测试队列：");
        MyQueue queue = new MyQueue();
        queue.in(1);
        queue.in(2);
        queue.in(3);
        System.out.println(queue.out());
        System.out.println(queue.out());
        queue.in(4);
        System.out.println(queue.out());
        System.out.println(queue.out());
        queue.in(5);
        System.out.println(queue.out());*/


        MyQueue3 queue = new MyQueue3();
        System.out.println("队列插入操作");
        queue.enQueue(20);
        queue.enQueue(15);
        queue.enQueue(10);
        queue.enQueue(5);

        System.out.println(queue.toString());
        System.out.println("队列获取元素");
        Integer data = queue.deQueue();
        System.out.println("获取的元素为：" + data);
        System.out.println(queue.toString());

        System.out.println("队列清空元素");
        queue.clean();
        System.out.println(queue.toString());
    }
}
