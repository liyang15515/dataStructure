package com.founder.demo.secondDay;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用集合定义一个队列
 */
public class MyQueue2 {
    List<Integer> list = new ArrayList<Integer>();
    int index = 0;  //下标

    //入队
    public void in(int n){
        list.add(n);
        index++;
    }

    //出队
    public int out(){
        if(!list.isEmpty()){
            index--;
            return list.remove(0);
        }
        return -1;
    }
}
