package leetcode;

public class MaxAncestorDiff {
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

  int maxDiff = 0;

  public int maxAncestorDiff(TreeNode root) {
    if (root == null) return 0;
    maxDiff = 0;
    findMinMax(root);
    return maxDiff;
  }

  private int[] findMinMax(TreeNode node) {
    int[] left = new int[] {node.val, node.val};
    int[] right = new int[] {node.val, node.val};
    if (node.left != null) left = findMinMax(node.left);
    if (node.right != null) right = findMinMax(node.right);

    int leftMin = left[0];
    int leftMax = left[1];

    int rightMin = right[0];
    int rightMax = right[1];

    var root = node.val;

    maxDiff =
        Math.max(
            maxDiff,
            Math.max(
                Math.max(Math.abs(root - leftMin), Math.abs(root - leftMax)),
                Math.max(Math.abs(root - rightMin), Math.abs(root - rightMax))));

    int min = Math.min(node.val, Math.min(leftMin, rightMin));
    int max = Math.max(node.val, Math.max(leftMax, rightMax));

    return new int[] {min, max};
  }

  public static void main(String[] args) {
    var mad = new MaxAncestorDiff();

    mad.maxAncestorDiff(
        new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, null, new TreeNode(3)))));
  }
}
