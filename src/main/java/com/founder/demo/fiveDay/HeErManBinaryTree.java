package com.founder.demo.fiveDay;

/**
 * 赫尔曼二叉树
 * 处理考试成绩分等级
 */
public class HeErManBinaryTree {
    public class TreeNode{
        private int index;
        private String data;
        private TreeNode leftChild;
        private TreeNode rightChild;
        //父节点
        private TreeNode parent;

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

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
    /**
     * 构建查找二叉树
     */
    public TreeNode putTreeNode(int key){
        return null;
    }

}
