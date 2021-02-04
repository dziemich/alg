package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthSmallestElementInBinaryTree {
  public int kthSmallest(TreeNode root, int k) {
    if (k <= 0) return -1;
    PriorityQueue<Integer> pq = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
    helper(root, pq, k);
    return pq.peek();
  }

  void helper(TreeNode node, PriorityQueue<Integer> pq, int capacity) {

    if (node == null) return;

    if (pq.isEmpty() || pq.size() < capacity) {
      pq.offer(node.val);
    } else {
      if (node.val < pq.peek()) {
        pq.poll();
        pq.offer(node.val);
      }
    }

    helper(node.left, pq, capacity);
    helper(node.right, pq, capacity);
  }
}
