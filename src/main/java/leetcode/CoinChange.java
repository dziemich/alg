package leetcode;

import java.util.Arrays;

public class CoinChange {
    int min = Integer.MAX_VALUE;


    public int coinChange(int[] coins, int amount) {
        min = Integer.MAX_VALUE;
        Arrays.sort(coins);

        helper(coins, 0, amount, 0);
        if(min == Integer.MAX_VALUE) return -1;

        return min;
    }

    private void helper(int[] coins, int coinCount, int target, int current){

        if(current > target || coinCount >= min) return;

        if(current == target){
            min = coinCount;
            return;
        }

        for(int i = coins.length - 1; i >=0; i--){
          if(coins[i] <= target - current)
            helper(coins, coinCount + 1, target, current + coins[i]);
        }
    }

  public static void main(String[] args) {
    var cc = new CoinChange();

    cc.coinChange(new int[] {1, Integer.MAX_VALUE},2);
  }
}
