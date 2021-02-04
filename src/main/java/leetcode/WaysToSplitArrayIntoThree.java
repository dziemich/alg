package leetcode;

import java.util.PriorityQueue;

public class WaysToSplitArrayIntoThree {
  public int waysToSplit(int[] nums) {


    /*

    1  2  2  2  5  0
     |     |

    */

    int sum = 0;
    for (int i : nums) sum += i;

    int leftSum = nums[0];
    int midSum = nums[1];
    int rightSum = sum - leftSum - midSum;

    int result = 0;

    for (int i = 1; i < nums.length - 1; i++) {

      int midCopy = midSum;
      int rightCopy = rightSum;
      for (int j = i + 1; j < nums.length; j++) {
        if (leftSum <= midCopy) {
          if (midCopy <= rightCopy) {
            result++;
          } else {
            break;
          }
        }
        midCopy += nums[j];
        rightCopy -= nums[j];
      }

      leftSum += nums[i];
      midSum = nums[i + 1];
      rightSum -= nums[i + 1];
    }

    return result;
  }

  public static void main(String[] args) {
    var wtsait = new WaysToSplitArrayIntoThree();

    int i = wtsait.waysToSplit(new int[] {1, 2, 2, 2, 5, 0});

    System.out.println("D: " + i);
  }
}
