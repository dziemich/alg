package leetcode;

public class LongestPalindrome {
  public String longestPalindrome(String s) {

    int len = s.length();

    String best = s.substring(0, 1);
    int max = 1;

    for (int i = 0; i < len; i++) {

      // assume s[i] is center
      int l = i;
      int r = i;

      while (l - 1 >= 0 && r + 1 < len && s.charAt(--l) == s.charAt(++r)) {
        int currLen = r - l + 1;
        if (currLen > max) {
          max = currLen;
          best = s.substring(l, r + 1);
        }
      }

      // assume s[i][i+1] is center
      if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
        if (max < 2) {
          max = 2;
          best = s.substring(i, i + 2);
        }

        l = i;
        r = i + 1;
        while (l - 1 >= 0 && r + 1 < len && s.charAt(--l) == s.charAt(++r)) {
          int currLen = r - l + 1;
          if (currLen > max) {
            max = currLen;
            best = s.substring(l, r + 1);
          }
        }
      }
    }
    return best;
  }

  public static void main(String[] args) {
    var lp = new LongestPalindrome();

    String input = "skjdnfgsdhbfnkvjsdnfaaabaaalkasdfadsnfasndjasndfsk";
    System.out.println(lp.longestPalindrome(input));
  }
}
