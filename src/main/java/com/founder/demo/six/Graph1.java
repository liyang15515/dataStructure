package com.founder.demo.six;

/**
 * 无向图
 */
public class Graph1 {
    private int vertexSize;//顶点数量
    private int [] vertexs;//顶点数组
    private int[][]  matrix;
    private static final int MAX_WEIGHT = 1000;
    private boolean [] isVisited;


    public Graph1(int vertextSize){
        this.vertexSize = vertextSize;
        matrix = new int[vertextSize][vertextSize];
        vertexs = new int[vertextSize];
        for(int i = 0;i<vertextSize;i++){
            vertexs[i] = i;
        }
        isVisited = new boolean[vertextSize];
    }

    /**
     * 深度搜索遍历 DFS
     */
    public void depthFirstSearch(){
        isVisited = new boolean[vertexSize];
//        for(int i = 0;i<vertexSize;i++){
//            if(!isVisited[i]){
//                System.out.println("访问到了："+i+"顶点");
//
//            }
//        }
        depthFirstSearch(0);
        return ;
    }

    /**
     * 深度搜索遍历 DFS
     */
    private void depthFirstSearch(int i){
        isVisited[i] = true;
        System.out.println("访问到了："+i+"顶点");
        int w = getNextNeighbor(i);
        while(w != -1){
            System.out.println("访问到了："+w+"顶点");
            w = getNextNeighbor(w);
        }
    }

    /**
     * 获取某个顶点的第一个邻接点(根据前一个邻接点的下标来取得下一个邻接点)
     * @return
     */
    private int getNextNeighbor(int index){
        for(int j=0;j<vertexSize;j++){
            if(matrix[index][j]!=0 && matrix[index][j]!=MAX_WEIGHT && isVisited[j] != true){
                isVisited[j] = true;
                return j;
            }
        }
        return -1;
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