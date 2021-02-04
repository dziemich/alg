package leetcode;

import java.util.List;
import java.util.Map;

public class DecodeWays {
  int counter = 0;
  // TimeLimitExceeded
  public int numDecodings2(String s) {
    counter = 0;
    tryDecode(s, s.substring(0, 1), 1);
    tryDecode(s, s.substring(0, 2), 2);
    return counter;
  }

  private void tryDecode(String s, String decoded, int level) {
    if (s.length() == level) {
      counter++;
      return;
    }

    int i = Integer.parseInt(decoded);

    if (decoded.length() == 1) {
      if (i != 0) {
        tryDecode(s, s.substring(level, level + 1), level + 1);
        if (level + 2 <= s.length()) {
          tryDecode(s, s.substring(level, level + 2), level + 2);
        }
      }
    }

    if (decoded.length() == 2) {
      if (i >= 10 && i <= 26) {
        tryDecode(s, s.substring(level, level + 1), level + 1);
        if (level + 2 <= s.length()) {
          tryDecode(s, s.substring(level, level + 2), level + 2);
        }
      }
    }
  }

  public int numDecodings(String s) {
    if (s.length() == 0) return 0;
    int dp[] = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i < dp.length; i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }
      Integer two = Integer.valueOf(s.substring(i - 2, i));
      if (two >= 10 && two <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[dp.length - 1];
  }

  public int numDecodingsHard(String s) {

    var map = Map.of(1, List.of(1));

//    map.computeIfPresent(2, )

    long mod = (long) Math.pow(10, 9) + 7;

    if (s.length() == 0) return 0;
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    var first = s.charAt(0);
    dp[1] = first == '0' ? 0 : first == '*' ? 9 : 1;

    for (int i = 2; i < dp.length; i++) {
      char c = s.charAt(i - 1);
      if (c != '0') {
        long value = dp[i];
        value += dp[i - 1];
        if (c == '*') {
          value *= 9;
        }
        dp[i] = (int) (value % mod);
      }

      String two = s.substring(i - 2, i);

      if (two.contains("*")) {
        long value = dp[i];
        value += dp[i - 2];
        char c1 = two.charAt(0);
        char c2 = two.charAt(1);
        if (c1 == '*' && c2 == '*') {
          value *= 17;
        } else if (c1 == '*') {
          if (Integer.parseInt(String.valueOf(c2)) <= 6) {
            value *= 2;
          }
        } else if (c2 == '*') {
          if (c1 == '1') {
            value *= 10;
          } else if (c1 == '2') {
            value *= 7;
          }
        }
        dp[i] = (int) (value % mod);
      } else {
        int noAsterisk = Integer.parseInt(s.substring(i - 2, i));
        if (noAsterisk >= 10 && noAsterisk <= 26) {
          dp[i] += dp[i - 2];
        }
      }
    }
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    var dw = new DecodeWays();
    System.out.println(dw.numDecodings("12"));
  }
}
