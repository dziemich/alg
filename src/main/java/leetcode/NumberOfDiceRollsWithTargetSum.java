package leetcode;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {

  static int DIV = 1_000_000_007;

  public int numRollsToTarget(int d, int f, int target) {

    int[] dp = new int[target + 1];
    int[] last = new int[target + 1];

    if (target < f) {
      f = target;
    }

    for (int i = 1; i <= f; i++) {
      last[i] = 1;
    }

    for (int i = 2; i <= d; i++) {
      for (int j = i; j <= Math.min(target, i * f); j++) {
        int sum = 0;
        for (int k = 1; k <= Math.min(j, f); k++) {
          sum = (sum + last[j-k]) % DIV;
        }
        dp[j] = sum;
      }
      last = dp.clone();
    }
    return last[target];
  }

  public static void main(String[] args) {
    var num = new NumberOfDiceRollsWithTargetSum();

    System.out.println(num.numRollsToTarget(3, 12, 27));
  }
}
