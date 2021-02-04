package leetcode;

public class ImplementTrie {

  static class Node {
    char val;
    boolean terminal;
    Node[] links = new Node[26];

    Node() {}

    Node(char val) {
      this.val = val;
    }
  }

  Node head = new Node();

  /** Initialize your data structure here. */
  public ImplementTrie() {}

  /** Inserts a word into the trie. */
  public void insert(String word) {
    if (word.length() == 0) return;
    insertRec(head, word);
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    return searchRec(head, word);
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    return startsWithRec(head, prefix);
  }

  void insertRec(Node curr, String word) {
    if (word.length() == 0) {
      curr.terminal = true;
      return;
    }

    char c = word.charAt(0);
    int idx = c - 'a';

    if (curr.links[idx] != null) {
      insertRec(curr.links[idx], word.substring(1));
    } else {
      Node n = new Node(c);
      curr.links[idx] = n;
      insertRec(n, word.substring(1));
    }
  }

  boolean searchRec(Node curr, String word) {
    if (word.length() == 0) return curr.terminal;
    int idx = word.charAt(0) - 'a';
    if (curr.links[idx] == null) return false;
    return searchRec(curr.links[idx], word.substring(1));
  }

  boolean startsWithRec(Node curr, String word) {
    if (word.length() == 0) return true;
    int idx = word.charAt(0) - 'a';
    if (curr.links[idx] == null) return false;
    return startsWithRec(curr.links[idx], word.substring(1));
  }

  public static void main(String[] args) {
    var trie = new ImplementTrie();

    trie.insert("apple");
    var a1 = trie.search("apple"); // returns true
    var a2 = trie.search("app"); // returns false
    var a3 = trie.startsWith("app"); // returns true
    trie.insert("app");
    var a4 = trie.search("app");
    System.out.println("D"); // returns true
  }
}
