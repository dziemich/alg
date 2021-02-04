package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeZigzagLevelOrderTraversal {
  HashMap<Integer, List<Integer>> map = new HashMap<>();

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    map = new HashMap<>();
    helper(root, 0);

    return new ArrayList<>(map.values());
  }

  void helper(TreeNode root, int level) {
    if (root == null) return;

    List<Integer> list = map.getOrDefault(level, new ArrayList<>());

    if (level % 2 == 1) {
      list.add(0, root.val);
    } else {
      list.add(root.val);
    }

    helper(root.left, level + 1);
    helper(root.right, level + 1);
  }
}
