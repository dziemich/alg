package leetcode;

import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {

      int counter = 0;

      Arrays.sort(nums);

      for(int i = 0; i < nums.length; i++){

        int k = i + 2;

        for(int j = i + 1; j < nums.length - 1; j++){
          while(j == k || k < nums.length - 1  && nums[i] + nums[j] > nums[k]){
            k++;
          }
          counter += k - j - 1;
        }
      }
      return counter;
    }

  public static void main(String[] args) {
    var vtn = new ValidTriangleNumber();
    vtn.triangleNumber(new int[]{0,1,1,1});
  }
}
