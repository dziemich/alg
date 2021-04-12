package leetcode;

import java.util.Arrays;

public class MissingNumber {
  public int missingNumber(int[] nums) {
    int supposed = nums.length * (nums.length + 1) / 2;
    int actual = Arrays.stream(nums).sum();
    return supposed - actual;
  }
}
