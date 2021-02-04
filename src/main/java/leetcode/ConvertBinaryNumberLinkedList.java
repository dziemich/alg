package leetcode;

public class ConvertBinaryNumberLinkedList {
  int sum = 0;
  int maxDepth = 0;

  public int getDecimalValue(ListNode head) {
    sum = 0;
    helper(head, 0);
    return sum;
  }

  void helper(ListNode node, int level) {
    if (node.next != null) {
      maxDepth++;
      helper(node.next, level + 1);
    }
    sum += node.val * Math.pow(2, maxDepth - level);
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    var cbnll = new ConvertBinaryNumberLinkedList();
    var list = new ListNode(1, new ListNode(0, new ListNode(1)));
    cbnll.getDecimalValue(list);
  }
}
