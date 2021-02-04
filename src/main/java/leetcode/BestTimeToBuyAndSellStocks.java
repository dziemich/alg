package leetcode;

public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

  public static void main(String[] args) {
        var stock = new BestTimeToBuyAndSellStocks();
        int i = stock.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2);
  }
}
