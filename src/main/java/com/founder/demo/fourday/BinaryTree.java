package com.founder.demo.fourday;

/**
 * 1、创建二叉树
 * 2、遍历二叉树（前序、中序、后序3种方式）
 * 3、求解二叉树的高度及某个节点的高度（递归算法）
 * 4、求解二叉树的节点数（递归算法）
 */

public class BinaryTree {

    private TreeNode root = null;

    /**
     * 构建树的根节点
     */
    public BinaryTree() {
        root = new TreeNode(1,"A");
    }

    /**
     * 构建二叉树
     *              A
     *      B               C
     * D        E                   F
     *
     */

    public void createBinaryTree(){
        TreeNode nodeB = new TreeNode(2,"B");
        TreeNode nodeC = new TreeNode(3,"C");
        TreeNode nodeD = new TreeNode(4,"D");
        TreeNode nodeE = new TreeNode(5,"E");
        TreeNode nodeF = new TreeNode(6,"F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;
    }

    /**
     * 计算树的高度
     */
    public int getHeight(){
        return getHeight(root);
    }
    /**
     * 计算节点的高度
     */
    private int getHeight(TreeNode treeNode){
        if(treeNode == null){
            return  0;
        }else{
            int i = getHeight(treeNode.leftChild);
            int j = getHeight(treeNode.rightChild);
            return (i>j)?i+1:j+1;
        }
    }
    /**
     * 获取某个节点下的节点数
     */
    private int getNodeSize(TreeNode node){
        if(node == null){
            return 0;
        }else{
            return 1+getNodeSize(node.leftChild)+getNodeSize(node.rightChild);
        }
    }
    /**
     * 获取二叉树的节点数
     * @param
     */
    public int getNodeSize(){
        return getNodeSize(root);
    }
    public static void main(String[] args){

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createBinaryTree();
        //求解二叉树的高度
        int height = binaryTree.getHeight();
        System.out.println(height);
        //求解二叉树的节点数
        int size = binaryTree.getNodeSize();
        System.out.println(size);
        //前序遍历二叉树
       binaryTree.preOrder(binaryTree.root);
        //后序遍历二叉树
            binaryTree.midOrder(binaryTree.root);
        //中序遍历二叉树
        binaryTree.postOrder(binaryTree.root);

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
    public void midOrder(TreeNode treeNode){
        if(treeNode == null){
            return ;
        }else{
            midOrder(treeNode.leftChild);
            System.out.println(treeNode.getIndex()+"中序遍历"+treeNode.getData());
            midOrder(treeNode.rightChild);
        }
    }
    public void postOrder(TreeNode treeNode){
        if(treeNode == null){
            return ;
        }else{
            postOrder(treeNode.leftChild);
            postOrder(treeNode.rightChild);
            System.out.println(treeNode.getIndex()+"后序遍历"+treeNode.getData());
        }
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
}
