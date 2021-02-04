package algoexpert;

import java.util.Stack;

public class ValidateBST {
  public boolean isValidBST(TreeNode root) {

    return helper(root, root.val, root.val);
  }

  private boolean helper(TreeNode node, int leftVal, int rightVal) {
    boolean isBST = false;

    if (node.left != null) {
      if (node.val > node.left.val && node.left.val > leftVal) {
        isBST = helper(node.left, leftVal, Math.min(node.left.val, rightVal));
        if (!isBST) return isBST;
      } else return false;
    }

    Stack<Integer> s = new Stack<>();

    if (node.right != null) {
      if (node.val < node.right.val && node.right.val < rightVal) {
        isBST = helper(node.right, Math.max(node.right.val, leftVal), rightVal);
        if (!isBST) return isBST;
      } else return false;
    }

    return true;
  }

  public static class TreeNode {
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

  public static void main(String[] args) {
    var tree = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    var vbst = new ValidateBST();

    boolean validBST = vbst.isValidBST(tree);
    System.out.println(validBST);
  }
}
