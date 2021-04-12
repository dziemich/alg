package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInString {
  public List<Integer> findAnagrams(String s, String p) {
    var pmap = new HashMap<Character, Integer>();
    var smap = new HashMap<Character, Integer>();

    int plen = p.length();

    for (int i = 0; i < plen; i++) {
      pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
      smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
    }

    var l = new ArrayList<Integer>();

    for (int i = plen; i < s.length(); i++) {

      if (pmap.keySet().stream()
          .allMatch(k -> pmap.getOrDefault(k, 0).equals(smap.getOrDefault(k, 0)))) {
        l.add(i - plen);
      }

      smap.put(s.charAt(i - plen), smap.get(s.charAt(i - plen)) - 1);
      if (smap.get(s.charAt(i - plen)).equals(0)) smap.remove(s.charAt(i - plen));

      smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
    }

    return l;
  }

  public static void main(String[] args) {
    var faain = new FindAllAnagramsInString();

    List<Integer> anagrams = faain.findAnagrams("cbaebabacd", "abc");
    System.out.println("DONE");
  }
}
