package leetcode;

public class ReverseLinkedList2 {
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

  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode anchor = new ListNode(-1);
    ListNode returned = anchor;

    ListNode current = head;

    for (int i = 1; current != null; i++) {

      if (i == m) {
        ListNode reversed = null;
        ListNode first = current;
        while (current != null && i <= n) {
          ListNode tail = current.next;
          current.next = reversed;
          reversed = current;
          current = tail;
          i++;
        }
        returned.next = reversed;
        returned = first;
      } else {
        returned.next = new ListNode(current.val);
        returned = returned.next;
        current = current.next;
      }
    }

    return anchor.next;
  }

  public static void main(String[] args) {
    var toReverse =
        new ReverseLinkedList2.ListNode(
            1,
            new ReverseLinkedList2.ListNode(
                2,
                new ReverseLinkedList2.ListNode(
                    3, new ReverseLinkedList2.ListNode(4, new ReverseLinkedList2.ListNode(5)))));

    var rll2 = new ReverseLinkedList2();

    var res = rll2.reverseBetween(toReverse, 2, 4);
    System.out.println("DONE");
  }
}
