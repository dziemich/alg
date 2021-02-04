package leetcode;

public class FlattenMultilevelDoublyLinkedList {

  // Definition for a Node.
  static class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
      this.val = val;
    }
  }

  public Node flatten(Node head) {

    Node current = head;

    while (current != null) {
      if (current.child != null) {
        Node tmp = current.next;
        Node flattened = flatten(current.child);
        current.child = null;

        flattened.prev = current;
        current.next = flattened;

        while (flattened.next != null) flattened = flattened.next;
        flattened.next = tmp;
        if (tmp != null) {
          tmp.prev = flattened;
        }
        current = tmp;
      } else {
        current = current.next;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    var n1 = new Node(1);
    var n2 = new Node(2);
    var n3 = new Node(3);
    var n4 = new Node(4);

    n1.next = n4;
    n4.prev = n1;

    n1.child = n2;
    n2.next = n3;
    n3.prev = n2;

    var fmdll = new FlattenMultilevelDoublyLinkedList();

    //    fmdll.flatten(n1);

    var n5 = new Node(5);
    var n6 = new Node(6);
    var n7 = new Node(7);

    n5.child = n6;
    n6.child = n7;

    fmdll.flatten(n5);
    System.out.println("DONE");
  }
}
