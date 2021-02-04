package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class FindTheSmallestDivisor {
  public int smallestDivisor(int[] nums, int threshold) {

    if (nums.length == 1) {
      return (int) Math.ceil((double) nums[0] / (double) threshold);
    }

    int divisor = nums[0];

    int left = 0;
    int right = Arrays.stream(nums).boxed().max(Integer::compareTo).get();
    int mid = (left + right) / 2;

    while (left <= right) {
      var sum = calcNumsForDivisor(nums, mid);
      if (sum <= threshold) {
        divisor = mid;
        right = mid - 1;
        mid = (left + right) / 2;
      } else {
        left = mid + 1;
        mid = (left + right) / 2;
      }
    }

    return divisor;
  }

  int calcNumsForDivisor(int[] nums, int div) {
    int sum = 0;

    for (int i : nums) {
      sum += Math.ceil((double) i / (double) div);
    }
    return sum;
  }

  public static void main(String[] args) {
    var ftsd = new FindTheSmallestDivisor();

    System.out.println(ftsd.smallestDivisor(new int[] {1, 2, 5, 9}, 6));
  }
}
