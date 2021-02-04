package leetcode;

public class BestTimeToBuyAndSellStocks3 {
  public int maxProfit(int[] prices) {

    if (prices.length <= 1) {
      return 0;
    }

    int bestDeal = 0;
    int secondBestDeal = 0;

    int lowest = prices[0];
    int largest = prices[0];

    for (int i = 1; i < prices.length; i++) {

      if (lowest > prices[i]) {
        lowest = prices[i];
        largest = prices[i];
      }

      if (largest < prices[i]) {
        largest = prices[i];
        var currentDeal = prices[i] - lowest;

        if (currentDeal > secondBestDeal) {
          lowest = largest;
        }

        secondBestDeal = Math.min(Math.max(currentDeal, secondBestDeal), bestDeal);
        bestDeal = Math.max(bestDeal, currentDeal);
      }
    }
    return bestDeal + secondBestDeal;
  }

  public static void main(String[] args) {

    var stocks = new BestTimeToBuyAndSellStocks3();

    System.out.println(stocks.maxProfit(new int[] {1,2,3,4,5}));
  }
}
