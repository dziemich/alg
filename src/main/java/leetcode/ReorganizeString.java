package leetcode;

import java.util.Stack;

public class ReorganizeString {
  public String reorganizeString(String S) {
    if (S.isEmpty()) return "";

    int[] counts = new int[26];

    for (char c : S.toCharArray()) {
      counts[c - 'a']++;
    }
    int max = counts[0];
    int letter = 0;
    for (int i = 1; i < counts.length; i++) {
      if (counts[i] > max) {
        max = counts[i];
        letter = i;
      }
    }
    if (max > (S.length() + 1) / 2) {
      return "";
    }

    char[] res = new char[S.length()];
    char maxL = (char) (letter + 'a');
    int idx = 0;
    for (int i = 0; i < max; i++) {
      res[idx] = maxL;
      idx += 2;
    }
    for (int i = 0; i < counts.length; i++) {
      if (i == letter) continue;
      int j = 0;
      while (j++ < counts[i]) {
        if (idx > res.length) idx = 1;
        res[idx] = (char) (i + 'a');
        idx += 2;
      }
    }

    return String.valueOf(res);
  }

  public static void main(String[] args) {

    var rs = new ReorganizeString();
    System.out.println(rs.reorganizeString("vvvloabcd"));
    //        System.out.println(rs.reorganizeString("aab"));
    //
  }
}
