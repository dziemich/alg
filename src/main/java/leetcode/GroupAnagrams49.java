package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams49 {

  public List<List<String>> groupAnagrams2(String[] strs) {
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

  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> anagrams = new HashMap<>();

    for (String s : strs) {
      String key = genKey(s);
      anagrams.computeIfPresent(
          key, (k, v) -> Stream.concat(Stream.of(s), v.stream()).collect(Collectors.toList()));
      anagrams.computeIfAbsent(key, x -> Stream.of(s).collect(Collectors.toList()));
    }
    return new ArrayList<>(anagrams.values());
  }

  String genKey(String s) {
    int[] occ = new int[26];
    for (char c : s.toCharArray()) {
      occ[c - 'a']++;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < occ.length; i++) {
      sb.append(i + 'a').append(occ[i]);
    }
    return sb.toString();
  }
}
