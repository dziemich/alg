package leetcode;

import java.util.*;

public class PathSum2 {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    helper(root, sum, result, new ArrayList<Integer>());
    return result;
  }

  void helper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> currentList) {
    if (node == null) return;
    var copy = new ArrayList<>(currentList);
    if (node.val == sum && node.left == null && node.right == null) {
      copy.add(node.val);
      result.add(copy);
      return;
    }
    copy.add(node.val);
    helper(node.left, sum - node.val, result, copy);
    helper(node.right, sum - node.val, result, copy);
  }

  public static void main(String[] args) {
    var ps2 = new PathSum2();

    //    var tree7 = new TreeNode(7, null, null);
    //    var tree2 = new TreeNode(2, null, null);
    //    var tree5a = new TreeNode(5, null, null);
    //    var tree1 = new TreeNode(1, null, null);
    //
    //    var tree11 = new TreeNode(11, tree7, tree2);
    //    var tree13 = new TreeNode(13, null, null);
    //    var tree4a = new TreeNode(4, tree5a, tree1);
    //
    //    var tree4 = new TreeNode(4, tree11, null);
    //    var tree8 = new TreeNode(8, tree13, tree4a);
    //
    //    var tree5 = new TreeNode(5, tree4, tree8);
    //    List<List<Integer>> lists = ps2.pathSum(tree5, 22);

    var tree0 = new TreeNode(0, new TreeNode(1, null, null), new TreeNode(1, null, null));

    List<List<Integer>> lists = ps2.pathSum(tree0, 1);

    System.out.println("DONE");
  }
}
