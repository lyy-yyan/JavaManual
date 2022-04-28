package homework;

public class MyBinaryTree {
    MyBinaryTree head;
    MyBinaryTreeNode treeNode;

    MyBinaryTree() {
        this.head = null;
        this.treeNode = null;
    }
}

class MyBinaryTreeNode {
    Integer data;
    MyBinaryTreeNode father;
    MyBinaryTreeNode left;
    MyBinaryTreeNode right;

    MyBinaryTreeNode() {
        this.data = 0;
        this.father = null;
        this.left = null;
        this.right = null;
    }
}
