package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class VowelSpellchecker {

  static List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');

  static class TrieNode {
    char val;
    HashMap<Character, TrieNode> links = new HashMap<>();
    boolean isTerminal;

    TrieNode() {}

    public TrieNode(char c) {
      val = c;
    }
  }

  static class Trie {

    TrieNode head = new TrieNode();

    void insert(String word) {
      TrieNode iter = head;

      while (!word.isEmpty()) {
        char c = word.charAt(0);
        TrieNode node = iter.links.get(c);

        if (node == null) {
          node = new TrieNode(c);
          iter.links.put(c, node);
        }

        if (word.length() == 1) {
          node.isTerminal = true;
        }

        iter = node;
        word = word.substring(1);
      }
    }

    String search(String word) {
      return searchRec(head, word, "");
    }

    private String searchRec(TrieNode node, String word, String curr) {
      if (word.length() == 0) return node.isTerminal ? curr : "";

      char c = word.charAt(0);
      List<Character> next = new ArrayList<>();

      if (vowels.contains(Character.toLowerCase(c))) {
        vowels.forEach(
            c1 -> {
              next.add(c1);
              next.add(Character.toUpperCase(c1));
            });
      } else {
        next.add(c);
        next.add(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
      }

      String ret = "";

      for (var n : next) {
        var link = node.links.get(n);
        if (link != null) {
          if (ret.isEmpty()) {
            var res = searchRec(link, word.substring(1), curr + link.val);
            if (!res.isEmpty()) ret = res;
          }
        }
      }
      return ret;
    }
  }

  public String[] spellchecker(String[] wordlist, String[] queries) {
    Trie trie = new Trie();
    for (String w : wordlist) {
      trie.insert(w);
    }
    String[] s = new String[queries.length];
    for (int i = 0; i < queries.length; i++) {
      s[i] = trie.search(queries[i]);
    }
    return s;
  }

  public static void main(String[] args) {
    var vs = new VowelSpellchecker();

    String[] spellchecker = vs.spellchecker(new String[] {"hare", "Hare"}, new String[] {"HARE"});
    System.out.println("DONE ");
  }
}
