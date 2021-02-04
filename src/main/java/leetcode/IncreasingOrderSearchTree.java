package leetcode;

import java.util.ArrayList;

public class IncreasingOrderSearchTree {

  ArrayList<Integer> values = new ArrayList<>();

  public TreeNode increasingBST(TreeNode root) {
    values = new ArrayList<>();
    helper(root);
    TreeNode anchor = new TreeNode();
    TreeNode it = anchor;
    for (int val : values) {
      it.right = new TreeNode(val);
      it = it.right;
    }
    return anchor.right;
  }

  void helper(TreeNode root) {

    if (root.left != null) {
      helper(root.left);
    }
    values.add(root.val);
    if (root.right != null) {
      helper(root.right);
    }
  }

  public static void main(String[] args) {

    var iost = new IncreasingOrderSearchTree();

    TreeNode treeNode = iost.increasingBST(new TreeNode(4, new TreeNode(1), new TreeNode(7)));

    System.out.println("DONE");
  }
}
