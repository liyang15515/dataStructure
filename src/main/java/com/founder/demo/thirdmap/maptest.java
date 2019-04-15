package com.founder.demo.thirdmap;

import java.util.*;

public class maptest {
    public static void main(String[] args){
        Map map = new HashMap();
        map.put(null,3);
        map.put(null,4);
        System.out.println(map);
        List list = new LinkedList();
        List list2 = new ArrayList();
        Set set = new HashSet();
        list.add(map);
        System.out.println(list);

    }
}
