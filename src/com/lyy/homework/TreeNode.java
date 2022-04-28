package homework;

public class TreeNode {
    int val;
    TreeNode left = new TreeNode();
    TreeNode right = new TreeNode();

    TreeNode() {
        this.val = 0;
        this.left = new TreeNode();
        this.right = new TreeNode();
    }

    TreeNode(int val) {
        this.val = val;
        this.left = new TreeNode();
        this.right = new TreeNode();
    }
}
