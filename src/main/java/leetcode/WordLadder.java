package leetcode;

import java.util.*;

public class WordLadder {
  Map<String, Integer> counts = new HashMap<>();
  Map<String, Set<String>> preprocessed = new HashMap<>();

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    if (!wordList.contains(endWord)) return 0;

    for (int i = 0; i < wordList.size(); i++) {
      var w1 = wordList.get(i);

      if (isSim(w1, beginWord)) {
        var list = preprocessed.getOrDefault(w1, new HashSet<>());
        list.add(beginWord);
        preprocessed.put(w1, list);
      }

      for (int j = 0; j < wordList.size(); j++) {
        if (i == j) continue;
        var w2 = wordList.get(j);

        if (isSim(w1, w2)) {
          var list = preprocessed.getOrDefault(w1, new HashSet<>());
          list.add(w2);
          preprocessed.put(w1, list);
        }
      }
    }

    counts.put(endWord, 0);
    HashSet<String> visited = new HashSet<>();
    visited.add(endWord);

    dfs(endWord, beginWord, visited, 1);
    return counts.getOrDefault(beginWord, 0);
  }

  void dfs(String start, String end, HashSet<String> visited, int currLen) {
    if (start.equals(end)) return;

    Set<String> iter = preprocessed.getOrDefault(start, new HashSet<>());
    for (String next : iter) {
      counts.put(next, Math.min(counts.getOrDefault(next, Integer.MAX_VALUE), currLen + 1));
      if (!visited.contains(next)) {
        var copy = new HashSet<>(visited);
        copy.add(next);
        dfs(next, end, copy, currLen + 1);
      }
    }
  }
  //
  //  int dfsxx(String start, String end, HashSet<String> visited) {
  //    if (start.equals(end)) {
  //      Integer def = counts.getOrDefault(start, Integer.MAX_VALUE);
  //      if (visited.size() > def) return def;
  //      counts.put(start, visited.size());
  //      return visited.size();
  //    }
  //
  //    if (counts.containsKey(start) && counts.get(start) < visited.size()) return
  // counts.get(start);
  //
  //    int res = Integer.MAX_VALUE;
  //
  //    Set<String> iter = preprocessed.getOrDefault(start, new HashSet<>());
  //    for (String next : iter) {
  //      if (!visited.contains(next)) {
  //        var copy = new HashSet<>(visited);
  //        copy.add(next);
  //        res = Math.min(res, dfsxx(next, end, copy));
  //      }
  //    }
  //
  //    counts.put(start, res);
  //    return res;
  //  }

  boolean isSim(String s1, String s2) {
    boolean oneDiff = false;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (!oneDiff) oneDiff = true;
        else {
          return false;
        }
      }
    }
    return oneDiff;
  }

  public static void main(String[] args) {
    var wl = new WordLadder();
    // Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    // "hot"
    // "dog"
    // ["hot","cog","dog","tot","hog","hop","pot","dot"]

    /*
            "hot"
        "dog"
        ["hot","dog","cog","pot","dot"]

        hot -> dot -> dog
    "hit"
    "cog"
    ["hot","dot","dog","lot","log","cog"]
             */

    int i = wl.ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog"));
    System.out.println(i);
    //
  }
}
