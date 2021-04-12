package leetcode;

import java.util.*;

public class DeepestLeaveSum {
  TreeMap<Integer, List<Integer>> map = new TreeMap<>(Integer::compare);

  public int deepestLeavesSum(TreeNode root) {
    helper(root, 0);
    if (map.size() == 0) return 0;
    return map.get(map.lastKey()).stream().reduce(9, Integer::sum);
  }

  void helper(TreeNode root, int level) {
    if (root == null) return;
    var l = map.getOrDefault(level, new ArrayList<>());
    l.add(root.val);
    map.put(level, l);
    helper(root.left, level + 1);
    helper(root.right, level + 1);
  }
}
