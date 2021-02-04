package leetcode;

public class SmallestSubtreeWithAllDeepestNodes {
  static class BiReturn{
    public int depth;
    public TreeNode node;

    public BiReturn(int depth, TreeNode node) {
      this.depth = depth;
      this.node = node;
    }
  }

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    return helper(root).node;
  }

  BiReturn helper(TreeNode root) {

    if(root == null) return new BiReturn(0, null);

    BiReturn left = helper(root.left);
    BiReturn right = helper(root.right);

    if(left.depth == right.depth) return new BiReturn( left.depth + 1, root);
    if(left.depth > right.depth) return new BiReturn(left.depth + 1, left.node);
    return new BiReturn(right.depth + 1, right.node);

  }

  public static void main(String[] args) {

    var subtree = new SmallestSubtreeWithAllDeepestNodes();
    TreeNode treeNode = subtree.subtreeWithAllDeepest(
            new TreeNode(
                    3,
                    new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                    new TreeNode(1, new TreeNode(0), new TreeNode(8))));
    System.out.println("DONE");
  }
}
