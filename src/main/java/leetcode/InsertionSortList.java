package leetcode;

public class InsertionSortList {

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

  public ListNode insertionSortList(ListNode head) {

    if (head.next == null) {
      return head;
    }

    var headVal = head.val;
    var ret = new ListNode(headVal);
    head = head.next;

    var anchor = new ListNode(Integer.MIN_VALUE, ret);

    while (head != null) {
      ret = anchor;
      while (ret.next != null && ret.next.val < head.val) {
        ret = ret.next;
      }

      var newNode = new ListNode(head.val, ret.next);
      ret.next = newNode;

      head = head.next;
    }
    return anchor.next;
  }

  public static void main(String[] args) {
    var input = new ListNode(5, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(9)))));

    var isl = new InsertionSortList();

    ListNode result = isl.insertionSortList(input);
    System.out.println("DONE");
  }
}
