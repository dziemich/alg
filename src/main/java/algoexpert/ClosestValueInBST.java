package algoexpert;

public class ClosestValueInBST {
  static int closestFound = 0;

  public static void helper(BST tree, int target) {
    var value = tree.value;
    if (value == target) {
      closestFound = target;
      return;
    }

    System.out.println("VAL IS: " + value);
    System.out.println("CLOSEST FOUND IS: " + value);

    System.out.println("CURR CLOSEST: " + Math.abs(closestFound - target));
    System.out.println("CANDIDATE CLOSEST: " + Math.abs(value - target));

    if (Math.abs(closestFound - target) > Math.abs(value - target)) {
      closestFound = value;
    }

    if (target < value && tree.left != null) {
      System.out.println("VISITING LEFT");
      findClosestValueInBst(tree.left, target);
    } else if (target > value && tree.right != null) {
      System.out.println("VISITING RIGHT");
      findClosestValueInBst(tree.right, target);
    }
  }

  public static int findClosestValueInBst(BST tree, int target) {
    if (tree == null) return -1;
    closestFound = tree.value;
    helper(tree, target);
    return closestFound;
  }

  public static void main(String[] args) {

    var tree10 = new BST(10);
    var tree1001 = new BST(1001);
    var tree501 = new BST(501);
    var tree55000 = new BST(55000);
    var tree1 = new BST(1);

    tree10.left = tree1;
    tree10.right = tree1001;

    tree1001.left = tree501;
    tree1001.right = tree55000;

    System.out.println(ClosestValueInBST.findClosestValueInBst(tree10, 2000));
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
