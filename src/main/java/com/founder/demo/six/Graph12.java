package com.founder.demo.six;


import java.util.ArrayList;
import java.util.List;

/**
 * 无向图的prim算法
 */
public class Graph12 {
    private int vertexSize;//顶点数量
    private int [] vertexs;//顶点数组
    private int[][]  matrix;
    private static final int MAX_WEIGHT = 1000;
    private boolean [] isVisited;
    private int sum2;
    private List<Integer> tree = new ArrayList<Integer>();
    public Graph12(int vertextSize){
        this.vertexSize = vertextSize;
        matrix = new int[vertextSize][vertextSize];
        vertexs = new int[vertextSize];
        for(int i = 0;i<vertextSize;i++){
            vertexs[i] = i;
        }
        isVisited = new boolean[vertextSize];
    }

    /**
     * 普利姆算法,仿造版
     */
    public void primByYanglee(){
        isVisited = new boolean[vertexSize];//判断顶点是否被遍历过
        sum2 = 0;//最短路径
        int min,minId;
        int index = getFirstNeighbor(0);
        sum2 += matrix[0][index];
        isVisited[0] = true;
        isVisited[index] = true;
        tree.add(0);
        tree.add(index);
        tree = getTreeNeighbor(tree);
        while(tree.size()<= vertexSize){
            tree = getTreeNeighbor(tree);
        }
        System.out.println("最小生成树权值和sum2:"+sum2);
    }

    /**
     * 获取第一个节点的'距离最短'邻接点
     * @param index
     */
    private int getFirstNeighbor(int index) {
        int min = 0;
        int nextIndex = 0;
        for (int i = 0; i < vertexSize; i++) {
            if(matrix[index][i]<MAX_WEIGHT && matrix[index][i] >0){
                if(min == 0){
                    min = matrix[index][i];
                    nextIndex = i;
                }
                if(min > matrix[index][i]){
                    min = matrix[index][i];
                    nextIndex = i;
                }
            }
        }
        return nextIndex;
    }

    /**
     * 获取当前树的"最短距离"邻接点
     * @param indexArray
     * @return
     */
    private List<Integer> getTreeNeighbor(List<Integer> indexArray){
        int min = 0;
        int nextIndex = 0;
        for(int index:indexArray){
            for(int i=0;i < vertexSize;i++){
                if(matrix[index][i]<MAX_WEIGHT && matrix[index][i] >0 && isVisited[i]== false){
                    if(min == 0){
                        min = matrix[index][i];
                        nextIndex = i;
                    }
                    if(min > matrix[index][i]){
                        min = matrix[index][i];
                        nextIndex = i;
                    }
                }
            }
        }
        tree.add(nextIndex);
        sum2+=min;
        return tree;
    }


    /**
     * 最小生成树算法：普利姆算法
     */
    public void prim(){
        int [] lowcost = new int[vertexSize];//最小代价顶点权值的数组,为0表示已经获取最小权值
        int [] adjvex = new int[vertexSize];//放置顶点遍历编号
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
