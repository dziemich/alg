class SumTwoLinkedLists {
  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//    long sum1 = 0;
//    long sum2 = 0;
//    long multiplier = 1;
//    while(l1 != null){
//      sum1 += multiplier * l1.val;
//      multiplier *= 10;
//      l1 = l1.next;
//    }
//    multiplier = 1;
//    while(l2 != null){
//      sum2 += multiplier * l2.val;
//      multiplier *= 10;
//      l2 = l2.next;
//    }
//    System.out.println(sum1);
//    System.out.println(sum2);
//
//    long sum = sum1 + sum2;
    ListNode head = new ListNode(0);
    ListNode next = head;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int l1s = 0;
      int l2s = 0;

      if (l1 != null){
        l1s = l1.val;
        l1 = l1.next;
      }

      if (l2 != null){
        l2s = l2.val;
        l2 = l2.next;
      }

      int sum = l1s + l2s + carry;

      if (sum > 9){
        sum -= 10;
        carry = 1;
      } else {
        carry = 0;
      }

      ListNode tmp = new ListNode(sum);
      next.next = tmp;
      next = next.next;

    }

    return head.next;
  }
}
