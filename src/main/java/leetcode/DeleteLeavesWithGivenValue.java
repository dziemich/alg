package leetcode;

public class DeleteLeavesWithGivenValue {
  public TreeNode removeLeafNodes(TreeNode root, int target) {
    if (isLeaf(root) && root.val == target) return null;
    helper(root, target);
    return root;
  }

  void helper(TreeNode root, int target) {

    if (root == null) return;
    var left = root.left;
    var right = root.right;

    helper(left, target);
    helper(right, target);

    if (left != null && isLeaf(left) && left.val == target) {
      root.left = null;
      left = null;
    }

    if (right != null && isLeaf(right) && right.val == target) {
      root.right = null;
      right = null;
    }
  }

  boolean isLeaf(TreeNode root) {
    return root.left == null && root.right == null;
  }

  public static void main(String[] args) {
    var input =
        new TreeNode(
            1,
            new TreeNode(2, new TreeNode(2), null),
            new TreeNode(3, new TreeNode(2), new TreeNode(4)));

    var dlwgv = new DeleteLeavesWithGivenValue();
    TreeNode treeNode = dlwgv.removeLeafNodes(input, 2);
    System.out.println("DON");
  }
}
