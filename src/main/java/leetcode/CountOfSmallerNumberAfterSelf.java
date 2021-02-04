package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountOfSmallerNumberAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        res[len-1] = 0;

        for(int i = len - 2; i>= 0; i--){
            for(int j = i + 1; j < len; j++){
                if(nums[j] < nums[i]){
                    res[i] = res[j] + 1;
                    break;
                }
            }
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

  public static void main(String[] args) {
    var cosnas = new CountOfSmallerNumberAfterSelf();

      List<Integer> integers = cosnas.countSmaller(new int[]{5, 2, 6, 1});
    System.out.println("DONE");
  }
}
