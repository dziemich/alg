package leetcode;

public class BinaryTreeTilt {
  int tilt = 0;

  public int findTilt(TreeNode root) {

    if (root == null)
    tilt = 0;
    int leftSum = 0;
    int rightSum = 0;
    if (root.left != null) leftSum = getSum(root.left);
    if (root.right != null) rightSum = getSum(root.right);
    tilt += Math.abs(leftSum - rightSum);
    return tilt;
  }

  private int getSum(TreeNode node) {
    int left = 0;
    int right = 0;
    if (node.left != null) left = getSum(node.left);
    if (node.right != null) right = getSum(node.right);

    tilt += Math.abs(left - right);
    return left + right + node.val;
  }

  public static void main(String[] args) {
    var tree = new TreeNode(1, new TreeNode(2), new TreeNode(3));

    var btt = new BinaryTreeTilt();
    btt.findTilt(tree);
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
