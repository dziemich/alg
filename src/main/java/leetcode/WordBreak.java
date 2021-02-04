package leetcode;

import java.util.*;

public class WordBreak {
  public boolean wordBreak(String s, List<String> wordDict) {
    HashSet<String> words = new HashSet<>(wordDict);
    return helper(s, words);
  }

  boolean helper(String s, HashSet<String> words) {
    if (s.isEmpty()) {
      return true;
    }

    for (var w : words) {
      if (s.startsWith(w)) {
        boolean b = helper(s.substring(w.length() + 1), words);
        if (b) return b;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    //

    var wb = new WordBreak();

    System.out.println(wb.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
  }
}
