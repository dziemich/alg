package leetcode;

public class BalanceBinaryTree {
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

  public boolean isBalanced(TreeNode root) {

    if (root == null) return true;

    int ll = getLevel(root.left, 0);
    int rr = getLevel(root.right, 0);

    return Math.abs(ll - rr) <= 1;
  }

  int getLevel(TreeNode node, int level) {
    if (node == null) {
      return level - 1;
    }

    return Math.max(getLevel(node.left, level + 1), getLevel(node.right, level + 1));
  }

  public static void main(String[] args) {
    var bb = new BalanceBinaryTree();

    var root =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null),
            new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));

    bb.isBalanced(root);
  }
}
