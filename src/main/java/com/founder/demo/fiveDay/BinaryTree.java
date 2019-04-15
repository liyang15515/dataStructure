package com.founder.demo.fiveDay;

import java.util.ArrayList;

/**
 * 二叉树
 */
public class BinaryTree {
    private TreeNode root = null;

    /**
     * 构建树的根节点
     */
    public BinaryTree() {
        root = new TreeNode(1,"A");
    }
    public class TreeNode{
        private int index;
        private String data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public int getIndex() {
            return index;
        }

        public TreeNode(int index, String data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }
    public static void main(String[] args) {
        String[] dataArray = new String[]{"A","B","D","#","#","E","#","#","C","#","F","#","#"};
        ArrayList<String> data = new ArrayList<>();
        for(String d:dataArray){
            data.add(d);
        }
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.createBinaryTreePre(data);
        binaryTree.preOrder(binaryTree.root);
    }
    //前序方式创建二叉树
    public void createBinaryTreePre(ArrayList<String> data){
        createBinaryTree(data.size(),data);
    }

    /**
     * 前序方式创建二叉树
     * @param size
     * @param data
     * @return
     */
    private TreeNode createBinaryTree(int size,ArrayList<String> data){
        if(data.size() == 0){
           return null;
        }
        String d = data.get(0);
        TreeNode node;
        int index = size - data.size();
        if(d.equals("#")){
            node = null;
            data.remove(0);
            return node;
        }
            node = new TreeNode(index,d);

        if(index == 0){
            root = node;
//            data.remove(0);
        }
            data.remove(0);
            node.leftChild = createBinaryTree(size,data);
            node.rightChild = createBinaryTree(size,data);

        return node;
    }
    public void  preOrder(TreeNode node){
        if(node == null){
            return ;
        }else{
            System.out.println(node.getIndex()+" &&&前序遍历&&& "+node.data);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }
}
