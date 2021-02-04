package leetcode;

public class CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {

    if (n == 0) return true;

    if (flowerbed.length <= 2) {
      if (n > 1) return false;
      return flowerbed[0] == 0;
    }

    int[] dp = new int[flowerbed.length + 1];

    dp[0] = flowerbed[0] == 0 ? 1 : 0;

    for (int i = 1; i < flowerbed.length; i++) {
      if (flowerbed[i] == 1) {
        dp[i]--;
        dp[i + 1] = dp[i];
      } else {
        dp[i + 1] = Math.max(dp[i - 1] + 1, dp[i]);
      }
    }

    return dp[flowerbed.length] >= n;
  }

  public static void main(String[] args) {
    var cpf = new CanPlaceFlowers();

    cpf.canPlaceFlowers(new int[] {0, 0, 1, 0}, 2);
  }
}
