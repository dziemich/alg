package leetcode;

public class IsValidBST {
  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }

  boolean helper(TreeNode node, Integer lower, Integer upper) {

    if (node == null) return true;

    int val = node.val;
    if (lower != null && val <= lower) return false;
    if (upper != null && val >= upper) return false;

    if (! helper(node.right, val, upper)) return false;
    if (! helper(node.left, lower, val)) return false;
    return true;

  }

  public static void main(String[] args) {
    var isbst = new IsValidBST();

    /*
                6
            3       8
         1    4  7     9

    */
    var node =
        new TreeNode(
            6,
            new TreeNode(3, new TreeNode(1), new TreeNode(4)),
            new TreeNode(8, new TreeNode(7), new TreeNode(9)));

    isbst.isValidBST(node);
  }
}
