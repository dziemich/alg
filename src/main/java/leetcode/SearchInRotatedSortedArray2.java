package leetcode;

import java.util.Arrays;

public class SearchInRotatedSortedArray2 {

  public boolean search(int[] nums, int target) {

    int left = 0;
    int right = nums.length - 1;

    int mid = (left + right) / 2;

    while (left <= right) {
      if (nums[mid] <= nums[right]) {
        right = mid + 1;
      } else {
        left = mid;
      }
      mid = (left + right) / 2;
    }

    return Arrays.binarySearch(nums, 0, mid, target) >= 0
        || Arrays.binarySearch(nums, mid, nums.length - 1, target) >= 0;
  }

  public static void main(String[] args) {
    var sir = new SearchInRotatedSortedArray2();

    sir.search(new int[] {2, 5, 6, 0, 0, 1, 2}, 0);
  }
}
