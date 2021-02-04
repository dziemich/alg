package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConstructBinaryTreePostInOrder {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0 || postorder.length == 0) return null;

    var rootVal = postorder[postorder.length - 1];
    if (inorder.length == 1 && postorder.length == 1) return new TreeNode(rootVal, null, null);
    int inIndex = 0;

    for (int i = inorder.length - 1; i > 0; i--) {
      if (inorder[i] == rootVal) {
        inIndex = i;
      }
    }

    var leftInorder = Arrays.stream(inorder).limit(inIndex).toArray();
    var rightInorder = Arrays.stream(inorder).skip(inIndex + 1).toArray();

    var leftPostorder = Arrays.stream(postorder).limit(leftInorder.length).toArray();
    var rightPostorderWithLast = Arrays.stream(postorder).skip(leftInorder.length).toArray();
    int[] rightPostorder;
    if (rightPostorderWithLast.length == 1) rightPostorder = new int[] {};
    else
      rightPostorder =
          Arrays.stream(rightPostorderWithLast).limit(rightPostorderWithLast.length - 1).toArray();

    return new TreeNode(
        rootVal, buildTree(leftInorder, leftPostorder), buildTree(rightInorder, rightPostorder));
  }
}
