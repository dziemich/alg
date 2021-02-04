package leetcode;

import java.util.ArrayList;

public class PathSum3 {
  int counter = 0;

  public int pathSum(TreeNode root, int sum) {
    if (root == null) return counter;
    helper(root, sum, new ArrayList<Integer>());
    return counter;
  }

  void helper(TreeNode node, int sum, ArrayList<Integer> list) {
    if (node == null) return;
    list.add(node.val);
    for (int i = 0; i < list.size(); i++) {
      if (list.stream().skip(i).reduce(Integer::sum).get() == sum) counter++;
    }
    var copy = new ArrayList<>(list);
    helper(node.left, sum, list);
    helper(node.right, sum, copy);
  }
}
