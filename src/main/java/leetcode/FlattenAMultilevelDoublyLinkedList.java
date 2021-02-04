package leetcode;

public class FlattenAMultilevelDoublyLinkedList {
  static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, Node next, Node child) {
      this.val = val;
      this.next = next;
      this.child = child;
    }
  }

  public Node flatten(Node head) {

    if (head == null) return null;

    Node anchor = new Node();
    Node prev = anchor;
    Node it = anchor;

    while (head != null) {
      it.next = new Node(head.val);
      it.next.prev = prev;
      it = it.next;
      prev = it;
      if (head.child != null) {
        Node flattened = flatten(head.child);
        flattened.prev = prev;
        it.next = flattened;
        while (it.next != null) {
          prev = it;
          it = it.next;
        }
      }
      head = head.next;
    }

    anchor.next.prev = null;
    return anchor.next;
  }

  public static void main(String[] args) {
    var fam = new FlattenAMultilevelDoublyLinkedList();

    Node flatten = fam.flatten(
            new Node(
                    1,
                    new Node(2,
                            new Node(3, null, null),
                            new Node(4, new Node(5, null, null), null)),
                    null));
    System.out.println("DONE");
  }
}
