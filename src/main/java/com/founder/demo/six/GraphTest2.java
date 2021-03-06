package com.founder.demo.six;

/**
 * 有向图的权值和出度、入度
 */
public class GraphTest2 {
    private static final int MAX_WEIGHT = 1000;
    public static void main(String[] args) {

        Graph2 graph2 = new Graph2(5);
        int [] a1 = new int[]{0,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,6};
        int [] a2 = new int[]{9,0,3,MAX_WEIGHT,MAX_WEIGHT};
        int [] a3 = new int[]{2,MAX_WEIGHT,0,5,MAX_WEIGHT};
        int [] a4 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,0,1};
        int [] a5 = new int[]{MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,MAX_WEIGHT,1};
        int[][]  matrix = new int[5][5];
        matrix[0] = a1;
        matrix[1] = a2;
        matrix[2] = a3;
        matrix[3] = a4;
        matrix[4] = a5;
        graph2.setMatrix(matrix);
        int index = 0;
        System.out.println("有向图graph2顶点【"+index+"】的出度是:"+graph2.getOutDegree(index));
        System.out.println("有向图graph2顶点【"+index+"】的入度是:"+graph2.getInDegree(index));
        int index1 = 1;
        System.out.println("===================================================");
        System.out.println("有向图graph2顶点【"+index+"】到顶点【"+index1+"】的权值是："+graph2.getWeight(index,index1));
        System.out.println("有向图graph2顶点【"+index1+"】到顶点【"+index+"】的权值是："+graph2.getWeight(index1,index));
        System.out.println("===================================================");
    }
}
