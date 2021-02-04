package leetcode;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingChars {
  public int longestSubstring(String s, int k) {
    char[] str = s.toCharArray();
    int manUniq = getMaxUnique(s);
    int result = 0;

    int[] countMap = new int[26];

    for (int currentUnique = 1; currentUnique < manUniq; currentUnique++) {

      int start = 0;
      int end = 0;

      int uniqueCount = 0;
      int kLimit = 0;

      Arrays.fill(countMap, 0);

      while (end < str.length) {
        if (uniqueCount <= currentUnique) {
          int index = str[end] - 'a';
          if (countMap[index] == 0) {
            uniqueCount++;
          }
          countMap[index]++;
          if (countMap[index] == k) {
            kLimit++;
          }
          end++;
        } else {
          int index = str[start] - 'a';
          if (countMap[index] == k) {
            kLimit--;
          }
          countMap[index]--;
          if (countMap[index] == 0) {
            uniqueCount--;
          }
          start++;
        }
        if (uniqueCount == currentUnique && uniqueCount == kLimit) {
          result = Math.max(end - start, result);
        }
      }
    }

    return result;
  }

  int getMaxUnique(String s) {
    boolean[] uniq = new boolean[26];
    int counter = 0;

    for (char c : s.toCharArray()) {

      if (!uniq[c - 'a']) {
        uniq[c - 'a'] = true;
        counter++;
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    var lswk = new LongestSubstringWithAtLeastKRepeatingChars();

    int res = lswk.longestSubstring("aaabbb", 3);
    System.out.println(res);
  }
}
