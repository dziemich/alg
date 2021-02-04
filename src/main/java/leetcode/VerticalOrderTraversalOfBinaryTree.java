package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VerticalOrderTraversalOfBinaryTree {
  TreeMap<Integer, List<int[]>> result = new TreeMap<>(Integer::compare);

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    if (root == null) return new ArrayList<>();

    result = new TreeMap<>();
    helper(root, 0, 0);

    List<List<Integer>> res = new ArrayList<>();

    for (var list : result.values()) {
      res.add(
          list.stream()
              .sorted(Comparator.comparingInt((int[] i) -> i[1]).thenComparingInt(i -> i[0]))
              .map(ints -> ints[0])
              .collect(Collectors.toList()));
    }
    HashMap<Character, Integer> chars = new HashMap<>();
    StringBuilder acc = new StringBuilder();
    chars.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue)).forEach(entry -> {
      for(int i = 0; i < entry.getValue(); i++){
        acc.append(entry.getKey());
      }
    });
    return res;
  }

  void helper(TreeNode node, int depth, int horizontal) {

    List<int[]> list = result.getOrDefault(horizontal, new ArrayList<>());
    list.add(new int[] {node.val, depth});
    result.put(horizontal, list);

    if (node.left != null) {
      helper(node.left, depth + 1, horizontal - 1);
    }

    if (node.right != null) {
      helper(node.right, depth + 1, horizontal + 1);
    }
  }
}
