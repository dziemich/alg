package leetcode;

public class UniquePaths {
  int[][] dp;

  public int uniquePaths(int m, int n) {
    dp = new int[m][n];
    return helper(m - 1, n - 1);
  }

  int helper(int m, int n) {
    if (m < 0 || n < 0) return 0;
    if (m == 1 && n == 0) return 1;
    if (m == 0 && n == 1) return 1;
    if (dp[m][n] != 0) return dp[m][n];

    int res = helper(m - 1, n) + helper(m, n - 1);
    dp[m][n] = res;
    return res;
  }

  public static void main(String[] args) {
    var up = new UniquePaths();
    int i = up.uniquePaths(80, 80);
    System.out.println("DONE " + i);
  }
  public boolean canJump(int[] nums) {
    if(nums.length == 0) return false;
    if(nums.length == 1) return true;

    int pos = nums.length - 1;

    for(int i = pos - 1; i >= 0; i--){
      if(i + nums[i] >= pos) pos = i;
    }

    return pos == 0;

  }
}
