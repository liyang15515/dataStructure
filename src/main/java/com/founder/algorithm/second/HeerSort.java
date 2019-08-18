package com.founder.algorithm.second;

/**
 * @Author yanglee
 * @Date 2019-08-04 16:01
 * @Description TODO 3、（插入排序之 shell sort）希尔排序
 * @Version 1.0
 **/
//不稳定
public class HeerSort {
    //希尔排序
    public static void main(String[] args) {
        int[] a={49,38,65,97,76,13,27,49,78,34,12,64,1,33,85,29};
//        int[] a={49,38,65,97,76,13,27,49};
        System.out.println("排序之前：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        //希尔排序
        System.out.println();
        int d = a.length/2;
        while(true){
            for(int i=0;i<d;i++){
                for(int j=i;j+d<a.length;j+=d){
                    int temp;
                    if(a[j]>a[j+d]){
                        temp=a[j];
                        a[j]=a[j+d];
                        a[j+d]=temp;
                    }
                }
            }
            if(d==1){break;}
            d--;
        }
        System.out.println();
        System.out.println("希尔排序，排序之后：");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }

}
