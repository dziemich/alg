package leetcode;

import java.util.*;

public class MaxLen1239 {
  int max = 0;

  public int maxLength(List<String> arr) {
    max = 0;
    helper2(arr, "", 0);
    return max;
  }

  void helper2(List<String> arr, String accumulator, int level) {
    max = Math.max(max, accumulator.length());
    if (level == arr.size() - 1) return;
    for (int i = 0; i < arr.size(); i++) {
      String concat = accumulator + arr.get(i);
      if (isValid(concat)) {
        helper2(arr, concat, level + 1);
      }
    }
  }

  private boolean isValid(String s) {
    Set<Character> charsPresent = new HashSet<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (charsPresent.contains(c)) return false;
      charsPresent.add(c);
    }
    return true;
  }

  public static void main(String[] args) {
    var ml = new MaxLen1239();
    System.out.println(
        ml.maxLength(
            List.of("un", "iq", "ue")));
  }
}
