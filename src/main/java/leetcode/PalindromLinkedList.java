package leetcode;

public class PalindromLinkedList {
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

  public boolean isPalindrome(ListNode head) {

    if (head == null) return false;

    int acc = 0;
    while (head != null) {
      acc *= 10;
      acc += head.val;
      head = head.next;
    }

    int x = acc % 10;
    acc /= 10;

    while (acc > x) {
      x *= 10;
      x += acc % 10;
      acc /= 10;
    }

    return (x == acc || x / 10 == acc);
  }

  public static void main(String[] args) {
    var pll = new PalindromLinkedList();

    pll.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))));
  }
}
