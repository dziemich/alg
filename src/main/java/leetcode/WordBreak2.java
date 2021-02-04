package leetcode;

import java.util.*;

public class WordBreak2 {
  List<String> result = new ArrayList<>();
  Set<String> dic = new HashSet<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    dic = new HashSet<String>(wordDict);
    helper(s, "");
    return result;
  }

  private void helper(String current, String acc) {
    if (current.isEmpty()) {
      result.add(acc.trim());
      return;
    }

    for (int i = 1; i <= current.length(); i++) {
      String sub = current.substring(0, i);
      if (dic.contains(sub)) {
        helper(current.substring(i), acc + " " + sub);
      }
    }
  }

  public static void main(String[] args) {
    var wb2 = new WordBreak2();

    List<String> strings =
        wb2.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));

    System.out.println("DONE");
  }
}
