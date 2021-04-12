package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstructBinaryTreePreInOrder {
  int preorderIndex;
  Map<Integer, Integer> inorderIndexMap;

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    preorderIndex = 0;
    // build a hashmap to store value -> its index relations
    inorderIndexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }

    return arrayToTree(preorder, inorder, 0, preorder.length - 1);
  }

  private TreeNode arrayToTree(int[] preorder, int[] inorder, int left, int right) {
    // if there are no elements to construct the tree
    if (left > right) return null;

    // select the preorder_index element as the root and increment it
    int rootValue = preorder[preorderIndex++];
    TreeNode root = new TreeNode(rootValue);

    // build left and right subtree
    // excluding inorderIndexMap[rootValue] element because it's the root
    root.left = arrayToTree(preorder, inorder, left, inorderIndexMap.get(rootValue) - 1);
    root.right = arrayToTree(preorder, inorder, inorderIndexMap.get(rootValue) + 1, right);
    int[] nums = new int[] {1};


    return root;
  }

  public static void main(String[] args) {
    var cbt = new ConstructBinaryTreePreInOrder();
    cbt.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
  }
}
