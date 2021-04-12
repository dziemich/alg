package leetcode;

import java.util.Arrays;

public class OnesAndZeroes {
  public int findMaxForm(String[] strs, int m, int n) {
    int l = strs.length;
    int[][] dp = new int[m + 1][n + 1];

    for (String str : strs) {
      int[] nums = calculate(str);
      for (int j = m; j >= nums[0]; j--) {
        for (int k = n; k >= nums[1]; k--) {
          if (j >= nums[0] && k >= nums[1]) {
            dp[j][k] = Math.max(dp[j][k], dp[j - nums[0]][k - nums[1]] + 1);
          }
        }
      }
    }
    return dp[m][n];
  }

  private int[] calculate(String str) {
    int[] res = new int[2];

    for (char c : str.toCharArray()) {
      res[c - '0']++;
    }
    return res;
  }

  public static void main(String[] args) {
    var oaz = new OnesAndZeroes();
    oaz.findMaxForm(new String[] {"111", "1000", "1000", "1000"}, 9, 3);
  }
}
