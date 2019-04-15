package com.founder.demo.firstDay;

public class MyLinkedListTest {
    public static void main(String[] args){
        MyLinkedList<String> liked = new MyLinkedList<String>();
        liked.add("a");
        liked.add("b");
        liked.add("c");
        liked.add("d");
        liked.add("c");
        System.out.println(liked);
        System.out.println(liked.get(0));
        System.out.println(liked.get(1));
        System.out.println(liked.size());
//        liked.remove(0);
//        System.out.println(liked.size());
//        System.out.println(liked.get(0));
        liked.remove("c");
        System.out.println(liked.size());
        System.out.println(liked.get(3));
    }
}
