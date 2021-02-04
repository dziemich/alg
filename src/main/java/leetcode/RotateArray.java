package leetcode;

import java.util.HashSet;

public class RotateArray {
    public void rotate(int[] nums, int k) {

        int[] other = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int next = (i + k) % nums.length;
            other[next] = nums[i];
        }

        System.arraycopy(other, 0, nums, 0, nums.length);
        var set = new HashSet<Integer>();
    }

    public static void main(String[] args) {
        var ra = new RotateArray();

        final int[] nums = {1, 2, 3, 4};
        ra.rotate(nums, 2);

        System.out.println("DONE");
    }
}
