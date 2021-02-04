package leetcode;

/** Definition for singly-linked list. */
public class RotateList {
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

  public ListNode rotateRight(ListNode head, int k) {

    if (head == null) return null;

    int len = 0;
    ListNode iter = head;

    while (iter != null) {
      len++;
      iter = iter.next;
    }

    int times = len - (k % len);

    if (times == 0) return head;

    iter = head;

    for (int i = 0; i < times - 1; i++) {
      iter = iter.next;
    }

    ListNode newHead = iter.next;
    iter.next = null;

    iter = newHead;
    while (iter.next != null) iter = iter.next;
    iter.next = head;

    return newHead;
  }

  public static void main(String[] args) {
    ListNode input =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    ListNode in2 = new ListNode(0, new ListNode(1, new ListNode(2)));

    var rl = new RotateList();

    ListNode output = rl.rotateRight(in2, 4);
  }
}
