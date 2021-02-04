package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class DetermineCloseStrings {
  public boolean closeStrings(String word1, String word2) {
    var reduced1 = reduce(word1);
    var reduced2 = reduce(word2);

    var keys1 = reduced1.keySet();
    var values1 = new HashSet<>(reduced1.values());

    var keys2 = reduced2.keySet();
    var values2 = new HashSet<>(reduced2.values());

    return keys1.containsAll(keys2)
        && keys2.containsAll(keys1)
        && values1.containsAll(values2)
        && values2.containsAll(values1);
  }

  Map<String, Integer> reduce(String word) {
    Map<String, Integer> count = new HashMap<>();
    Arrays.stream(word.split("")).forEach(s -> count.put(s, count.getOrDefault(s, 0) + 1));
    return count;
  }

  public static void main(String[] args) {}
}
