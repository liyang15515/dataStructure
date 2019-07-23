package com.founder.demo.six;

/**
 * 无向图的深度遍历（正确案例：难点）
 */
public class Graph11 {
    private int vertexSize;//顶点数量
    private int [] vertexs;//顶点数组
    private int[][]  matrix;
    private static final int MAX_WEIGHT = 1000;
    private boolean [] isVisited;


    public Graph11(int vertextSize){
        this.vertexSize = vertextSize;
        matrix = new int[vertextSize][vertextSize];
        vertexs = new int[vertextSize];
        for(int i = 0;i<vertextSize;i++){
            vertexs[i] = i;
        }
        isVisited = new boolean[vertextSize];
    }
    /**
     * 根据前一个邻接点的下标来取得下一个邻接点
     * @param v 表示要找的顶点
     * @param index 表示该顶点相对于哪个邻接点去获取下一个邻接点
     */
    public int getNextNeighbor(int v,int index){
        for(int j = index+1;j<vertexSize;j++){
            if(matrix[v][j]>0&&matrix[v][j]<MAX_WEIGHT){
                return j;
            }
        }
        return -1;
    }
    /**
     * 获取某个顶点的第一个邻接点
     */
    public int getFirstNeighbor(int index){
        for(int j = 0;j<vertexSize;j++){
            int temp = matrix[index][j];
            if(temp > 0 && temp < MAX_WEIGHT){
                return j;
            }
        }
        return -1;
    }

    /**
     * 图的深度优先遍历算法
     */
    private void depthFirstSearch(int i){
        isVisited[i] = true;
        int w = getFirstNeighbor(i);//
        while(w!=-1){
            if(!isVisited[w]){
                //需要遍历该顶点
                System.out.println("访问到了："+w+"顶点");
                depthFirstSearch(w);
            }
            w = getNextNeighbor(i, w);//第一个相对于w的邻接点
        }
    }

    /**
     * 对外公开的深度优先遍历
     */

    public void depthFirstSearch(){
        isVisited = new boolean[vertexSize];
        for(int i = 0;i<vertexSize;i++){
            if(!isVisited[i]){
                System.out.println("访问到了："+i+"顶点");
                depthFirstSearch(i);
            }
        }
        isVisited = new boolean[vertexSize];
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
