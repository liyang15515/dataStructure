package com.founder.demo.six;

/**
 * 图的邻接矩阵(有向图)
 */
public class Graph2 {
    private int vertexSize;//顶点数量
    private int [] vertexs;//顶点数组
    private int[][]  matrix;
    private static final int MAX_WEIGHT = 1000;
    private boolean [] isVisited;


    public Graph2(int vertextSize){
        this.vertexSize = vertextSize;
        matrix = new int[vertextSize][vertextSize];
        vertexs = new int[vertextSize];
        for(int i = 0;i<vertextSize;i++){
            vertexs[i] = i;
        }
        isVisited = new boolean[vertextSize];
    }

    /**
     * 顶点的出度
     */
    public int getOutDegree(int index){
        int degree = 0;
        for(int j=0;j<matrix[index].length;j++){
            int temp = matrix[index][j];
            if(temp != 0 && temp != MAX_WEIGHT){
                degree++;
            }
        }
        return degree;
    }

    /**
     * 顶点的入度
     * @param index
     * @return
     */
    public int getInDegree(int index){
        int degree = 0;
        for(int i=0;i<matrix[index].length;i++){
            int temp = matrix[i][index];
            if(temp != 0 && temp != MAX_WEIGHT){
                degree++;
            }
        }
        return degree;
    }

    /**
     * 顶点之间的权值
     * @return
     */
    public int getWeight(int v1,int v2){
        int weight = matrix[v1][v2];
        return weight == 0?0:(weight == MAX_WEIGHT?-1:weight);
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
