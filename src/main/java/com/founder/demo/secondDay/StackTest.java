package com.founder.demo.secondDay;

import java.util.Stack;

/**
 * java中，栈 是如何实现的
 * 1、栈的创建--->栈继承了vector，而vector实现了List接口；
 *      所以Java基于栈的实现有2种,一种是基于arrayList的数组，一种是基于linkedList的链表，
 *      只不过栈是单向链表，而LinkedList是双向链表
 * 2、栈的"增删改查"操作
 */
public class StackTest {
    public static void main(String[] args) {
        MyStack2 stack = new MyStack2();

        //入栈 push()方法
        stack.push(2);
        stack.push(3);
        stack.push(4);
        //出栈 pop()方法
         int size = stack.length();
         System.out.println(size);
         for(int i=1;i<=size;i++){
             System.out.println(stack.pop());
         }
        //查询 search()方法
    }
}
