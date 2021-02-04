package leetcode;

public class SumOfRootToLeafBinaryNumbers {
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

  int result = 0;

  public int sumRootToLeaf(TreeNode root) {
    result = 0;
    helper(root, new StringBuilder());
    return result;
  }

  void helper(TreeNode root, StringBuilder acc) {
    acc.append(root.val);
    if (root.left == null && root.right == null) {
      String num = acc.toString();
      int mul = 1;
      int a = 0;
      for (int i = num.length() - 1; i >= 0; i--) {
        a += (num.charAt(i) - '0') * mul;
        mul *= 2;
      }
      result += a;
    }
    if (root.left != null) {
      helper(root.left, new StringBuilder(acc.toString()));
    }
    if (root.right != null) {
      helper(root.right, new StringBuilder(acc.toString()));
    }
  }

  public static void main(String[] args) {
    var sor = new SumOfRootToLeafBinaryNumbers();
    int result =
        //        sor.sumRootToLeaf(
        //            new TreeNode(
        //                1,
        //                new TreeNode(0, new TreeNode(0), new TreeNode(1)),
        //                new TreeNode(1, new TreeNode(0), new TreeNode(1))));
        sor.sumRootToLeaf(new TreeNode(0, new TreeNode(1), new TreeNode(1)));

    System.out.println(result);
  }
}
