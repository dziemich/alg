package leetcode;

import java.util.*;

public class BinaryTreeVerticalTraversal {

  LinkedHashMap<String, List<Integer>> map = new LinkedHashMap<>();

  public List<List<Integer>> verticalOrder(TreeNode root) {
    if (root == null) return Collections.emptyList();

    map = new LinkedHashMap<>();
    helper(root, 0, 0);
    return new ArrayList<>(map.values());
  }

  void helper(TreeNode root, int vertical, int horizontal) {
    if (root.left != null) {
      helper(root.left, vertical + 1, horizontal - 1);
    }

    String pair = horizontal + "|" + vertical;

    List<Integer> list = map.getOrDefault(pair, new LinkedList<>());
    list.add(root.val);
    map.put(pair, list);

    if (root.right != null) {
      helper(root.right, vertical + 1, horizontal + 1);
    }
  }

  public static void main(String[] args) {
    //

    var tree =
        new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

    var btvt = new BinaryTreeVerticalTraversal();

    List<List<Integer>> lists = btvt.verticalOrder(tree);
    System.out.println("DONE");
  }
}
