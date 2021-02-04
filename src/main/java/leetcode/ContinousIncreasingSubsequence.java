package leetcode;

import java.util.Arrays;

public class ContinousIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, len, num);
      if (i < 0) {
        i = -(i + 1);
      }
      dp[i] = num;
      if (i == len) {
        len++;
      }
    }
    return len;
  }

  public static void main(String[] args) {
    var cis = new ContinousIncreasingSubsequence();

    //    System.out.println(cis.lengthOfLIS(new int[] {5, 6, 7, 1, 2, 3, 4})); OK
    System.out.println(cis.lengthOfLIS(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
  }
}
