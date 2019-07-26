package com.founder.demo.six;


/**
 * 无向图的prim算法
 */
public class Graph12 {
    private int vertexSize;//顶点数量
    private int [] vertexs;//顶点数组
    private int[][]  matrix;
    private static final int MAX_WEIGHT = 1000;
    private boolean [] isVisited;
    public Graph12(int vertextSize){
        this.vertexSize = vertextSize;
        matrix = new int[vertextSize][vertextSize];
        vertexs = new int[vertextSize];
        for(int i = 0;i<vertextSize;i++){
            vertexs[i] = i;
        }
        isVisited = new boolean[vertextSize];
    }
    public void prim(){
        int [] lowcost = new int[vertexSize];//最小代价顶点权值的数组,为0表示已经获取最小权值
        int [] adjvex = new int[vertexSize];//放顶点权值
        int min,minId,sum = 0;
        for(int i = 1;i<vertexSize;i++){
            lowcost[i] = matrix[0][i];
        }
        for(int i = 1;i<vertexSize;i++){
            min = MAX_WEIGHT;
            minId = 0;
            for(int j = 1;j<vertexSize;j++){
                if(lowcost[j]<min&&lowcost[j]>0){
                    min = lowcost[j];
                    minId = j;
                }
            }
            System.out.println("顶点："+adjvex[minId]+"权值："+min);
            sum+=min;
            lowcost[minId] = 0;
            for(int j = 1;j<vertexSize;j++){
                if(lowcost[j]!=0&&matrix[minId][j]<lowcost[j]){
                    lowcost[j] = matrix[minId][j];
                    adjvex[j] = minId;
                }
            }
        }
        System.out.println("最小生成树权值和:"+sum);
    }


    public int getVertexSize() {
        return vertexSize;
    }

    public void setVertexSize(int vertexSize) {
        this.vertexSize = vertexSize;
    }

    public int[] getVertexs() {
        return vertexs;
    }

    public void setVertexs(int[] vertexs) {
        this.vertexs = vertexs;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
}
