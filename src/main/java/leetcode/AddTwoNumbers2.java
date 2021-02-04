package leetcode;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class AddTwoNumbers2 {
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

  public ListNode addTwoNumbersX(ListNode l1, ListNode l2) {

    var reversed1 = reverseList(l1);
    var reversed2 = reverseList(l2);

    int carry = 0;

    var anchor = new ListNode();
    var it = anchor;

    while (reversed1 != null || reversed2 != null) {

      var val1 = reversed1 == null ? 0 : reversed1.val;
      var val2 = reversed2 == null ? 0 : reversed2.val;

      int sum = val1 + val2 + carry;
      carry = sum >= 10 ? 1 : 0;

      it.next = new ListNode(sum % 10);
      it = it.next;
      if (reversed1 != null) reversed1 = reversed1.next;
      if (reversed2 != null) reversed2 = reversed2.next;
    }

    var result = reverseList(anchor.next);

    if (carry == 1) {
      return new ListNode(1, result);
    } else return result;
  }

  private ListNode reverseList(ListNode node) {
    ListNode prev = null;
    ListNode current = node;
    ListNode next = null;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    node = prev;
    return node;
  }

  public ListNode addTwoNumbersxx(ListNode l1, ListNode l2) {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    while (l1 != null) {
      s1.push(l1.val);
      l1 = l1.next;
    }

    while (l2 != null) {
      s2.push(l2.val);
      l2 = l2.next;
    }

    int carry = 0;

    ListNode ret = new ListNode();

    while (!s1.isEmpty() && !s2.isEmpty()) {
      int i1 = s1.isEmpty() ? 0 : s1.pop();
      int i2 = s2.isEmpty() ? 0 : s2.pop();
      int sum = i1 + i2 + carry;
      carry = sum / 10;
      sum = sum % 10;
      ListNode tail = ret.next;
      ListNode n = new ListNode(sum);
      n.next = tail;
      ret.next = n;
    }

    if (carry != 0) {
      ListNode tail = ret.next;
      ListNode n = new ListNode(carry);
      n.next = tail;
      ret.next = n;
    }

    return ret.next;
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int size1 = getLength(l1);
    int size2 = getLength(l2);
    ListNode head = new ListNode(1);
    // Make sure l1.length >= l2.length
    head.next = size1 < size2 ? helper(l2, l1, size2 - size1) : helper(l1, l2, size1 - size2);
    // Handle the first digit
    if (head.next.val > 9) {
      head.next.val = head.next.val % 10;
      return head;
    }
    return head.next;
  }
  // get length of the list
  public int getLength(ListNode l) {
    int count = 0;
    while (l != null) {
      l = l.next;
      count++;
    }
    return count;
  }
  // offset is the difference of length between l1 and l2
  public ListNode helper(ListNode l1, ListNode l2, int offset) {
    if (l1 == null) return null;
    // check whether l1 becomes the same length as l2
    ListNode result = offset == 0 ? new ListNode(l1.val + l2.val) : new ListNode(l1.val);
    ListNode post = offset == 0 ? helper(l1.next, l2.next, 0) : helper(l1.next, l2, offset - 1);
    // handle carry
    if (post != null && post.val > 9) {
      result.val += 1;
      post.val = post.val % 10;
    }
    // combine nodes
    result.next = post;
    return result;
  }

  public static void main(String[] args) {
    //    var l1 = new ListNode(9, new ListNode(1, new ListNode(8, new ListNode(8))));
    //    var l2 = new ListNode(1, new ListNode(1, new ListNode(2)));

    var l1 = new ListNode(3, new ListNode(1, new ListNode(2, new ListNode(3))));
    var l2 = new ListNode(4, new ListNode(4, new ListNode(4, new ListNode(4))));
    var atn2 = new AddTwoNumbers2();
//    System.out.println(atn2.addTwoNumbers(l1, l2));
  }
}
