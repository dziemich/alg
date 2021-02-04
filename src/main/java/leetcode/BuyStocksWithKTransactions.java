package leetcode;

import java.util.Arrays;

public class BuyStocksWithKTransactions {
  public int maxProfit(int k, int[] prices) {
    int[] nums = new int[k];
    int[] profits = new int[k];
    Arrays.fill(nums, Integer.MAX_VALUE);
    int maxProfit = 0;
    for (int i = 0; i < prices.length; i++) {
      int profit = 0;
      // extend to K transaction  from 2 transaction.
      for (int j = 0; j < k; j++) {
        nums[j] = Math.min(nums[j], prices[i] - profit);
        profits[j] = Math.max(profits[j], prices[i] - nums[j]);
        profit = profits[j];
      }
      maxProfit = Math.max(maxProfit, profit);
    }
    return maxProfit;
  }

  public static void main(String[] args) {
    var bswk = new BuyStocksWithKTransactions();
    bswk.maxProfit(2, new int[] {3, 2, 6, 5, 0, 3});
    //
  }
}
