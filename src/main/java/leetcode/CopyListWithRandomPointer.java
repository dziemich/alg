package leetcode;

public class CopyListWithRandomPointer {

  static class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }

//    public Node copyRandomList(Node head) {
//      if (head == null) return head;
//
//      Node it = head;
//
//      while (it != null) {
//        Node copy = new Node(it.val);
//        copy.next = it.next;
//        it.next = copy;
//        it = copy.next;
//      }
//
//      it = head;
//
//      while (it != null) {
//        Node random = it.random == null ? null : it.random;
//        it.next.random = random == null ? null : random.next;
//        it = it.next.next;
//      }
//
//      Node anchor = new Node(-1);
//      anchor.next = head.next;
//      Node ita = anchor.next;
//      it = head.next.next.next;
//
//      while (it != null) {
//        ita.next = it;
//        ita = ita.next;
//        it = it.next == null ? null : it.next.next;
//      }
//      return anchor.next;
//    }

  public Node copyRandomList(Node head) {

    if (head == null) return null;

    //  ----------
    // |          |
    // A -> A' -> B -> B' -> null
    //      |          |
    //       ----------
    var iter = head;

    while (iter != null) {
      Node tail = iter.next;
      Node copy = new Node(iter.val);
      copy.next = tail;
      iter.next = copy;
      iter = tail;
    }

    iter = head;

    while (iter != null) {
      if (iter.random != null) {
        iter.next.random = iter.random.next;
      }
      iter = iter.next.next;
    }

    Node oldIt = head;
    Node newIt = head.next;
    Node anchor = head.next;

    while(oldIt != null){
      oldIt.next = oldIt.next.next;
      oldIt = oldIt.next;
      newIt.next = oldIt == null ? null : oldIt.next;
      newIt = newIt.next;
    }

    return anchor;
  }

  public static void main(String[] args) {
    var n1 = new Node(1);
    var n2 = new Node(2);
    var n3 = new Node(3);

    n1.next = n2;
    n1.random = n3;

    n2.next = n3;
    n2.random = n1;

    var copy = new CopyListWithRandomPointer();

    Node res = copy.copyRandomList(n1);
    System.out.println("DONE");
  }
}
