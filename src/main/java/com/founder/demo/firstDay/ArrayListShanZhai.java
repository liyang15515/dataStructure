package com.founder.demo.firstDay;


public class ArrayListShanZhai {
    public static void main(String[] args){
        /**
         *         ArrayList底层由数组实现
         *         1、搞明白arrayList自动扩容如何实现的
         *         2、arrayList的增删改查方法的实现
         */
        MyArrayList<String> list = new MyArrayList<String>();
        //看源码add如何实现的
        list.add("a");
        list.add("b");
        list.add("a");
        //看源码remove如何实现
//        list.remove(1);
//        list.remove("a");
        //set方法是进行修改值update操作
        System.out.println(list);
            System.out.println(list.get(0));
            System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.size());
    }
}
