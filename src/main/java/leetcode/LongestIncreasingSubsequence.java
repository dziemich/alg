package leetcode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] piles = new int[nums.length]; // store the smallest number(or top card) of each pile.
        int numPiles = 0;
        for (int num: nums) {
            int destPile = Arrays.binarySearch(piles, 0, numPiles, num);
            if (destPile < 0) {
                destPile = -(destPile + 1); // Arrays.binarySearch returns -(insertion point) - 1 if not found
            }
            piles[destPile] = num;
            if (destPile == numPiles) {
                numPiles++;
            }
        }
        return numPiles;
    }

  public static void main(String[] args) {
    var lis = new LongestIncreasingSubsequence();

    lis.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
  }
}
