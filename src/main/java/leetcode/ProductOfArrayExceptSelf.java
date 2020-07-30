package leetcode;

/*
https://leetcode.com/problems/product-of-array-except-self/
 */

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];

        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - i];
        }
        for(int i = 0; i < nums.length; i++){
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
