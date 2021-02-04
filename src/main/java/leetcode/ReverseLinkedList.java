package leetcode;

import java.util.Stack;

public class ReverseLinkedList {
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

  public ListNode reverseListIt(ListNode head) {
    ListNode p = null;
    ListNode c = head;

    while (c != null) {
      ListNode tmp = c.next;
      c.next = p;
      p = c;
      c = tmp;
    }

    return p;
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }

  public static void main(String[] args) {
    var toReverse =
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    var rll = new ReverseLinkedList();

    var res = rll.reverseList(toReverse);
    System.out.println("DONE");
  }
}
