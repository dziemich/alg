package leetcode;

import java.util.Arrays;

public class JumpGame2 {
  public int jump(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }

    int maxReach = nums[0], steps = maxReach, jumps = 0;
    for (int i = 1; i < nums.length - 1; ++i) {
      maxReach = Math.max(maxReach, nums[i] + i);
      steps--;
      if (steps == 0) {
        jumps++;
        steps = maxReach - i;
      }
    }


    return jumps + 1;
  }

  public static void main(String[] args) {
    var jg2 = new JumpGame2();
    //    System.out.println(jg2.jump(new int[] {3,1,1,1,1}));
    System.out.println(jg2.jump(new int[] {1, 3, 1, 1, 4}));
    //    System.out.println(jg2.jump(new int[] {2, 3, 1, 1, 4}));
  }
}
