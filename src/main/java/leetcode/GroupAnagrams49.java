package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams49 {

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> anagrams = new HashMap<>();

    for (String s : strs) {

      var arr = s.toCharArray();
      Arrays.sort(arr);
      String key = new String(arr);
      anagrams.computeIfAbsent(key, x -> Stream.of(s).collect(Collectors.toList()));
      anagrams.computeIfPresent(
          key, (k, v) -> Stream.concat(Stream.of(s), v.stream()).collect(Collectors.toList()));
    }
    return new ArrayList<>(anagrams.values());
  }
}
