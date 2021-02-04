package algoexpert;

public class MaxPathSum {

  public static int maxPathSum(BinaryTree tree) {
    var tuple = helper(tree);
    return Math.max(tuple.first, tuple.second);
  }

  public static Tuple helper(BinaryTree tree) {
    if (tree.left == null && tree.right == null) return new Tuple(tree.value, Integer.MIN_VALUE);
    Tuple leftSubtree = new Tuple(Integer.MIN_VALUE, Integer.MIN_VALUE);
    Tuple rightSubtree = new Tuple(Integer.MIN_VALUE, Integer.MIN_VALUE);
    if (tree.left != null) leftSubtree = helper(tree.left);
    if (tree.right != null) rightSubtree = helper(tree.right);

    int maxIfLeftOrRight =
        Math.max(
            tree.value, Math.max(tree.value + leftSubtree.first, tree.value + rightSubtree.first));
    int maxIfBoth =
        Math.max(
            rightSubtree.second,
            Math.max(
                leftSubtree.second,
                Math.max(maxIfLeftOrRight, tree.value + leftSubtree.first + rightSubtree.first)));

    return new Tuple(maxIfLeftOrRight, maxIfBoth);
  }

  static class Tuple {
    public int first;
    public int second;

    public Tuple(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  static class BinaryTree {
    public int value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
    }
  }

  public static void main(String[] args) {

    var tree1 = new BinaryTree(1);
    var tree2 = new BinaryTree(2);
    var tree3 = new BinaryTree(3);
    var tree4 = new BinaryTree(4);
    var tree5 = new BinaryTree(5);
    var tree6 = new BinaryTree(6);
    var tree7 = new BinaryTree(7);

    tree1.left = tree2;
    tree1.right = tree3;
    tree2.left = tree4;
    tree2.right = tree5;
    tree3.left = tree6;
    tree3.right = tree7;

    System.out.println(maxPathSum(tree1));
  }
}
