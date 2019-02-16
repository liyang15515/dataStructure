package com.founder.demo.thirdmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class maptest {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put(null,3);
        map.put(null,4);
        System.out.println(map);
        List list = new LinkedList();
        list.add(map);
        System.out.println(list);

    }
}
