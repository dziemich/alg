package leetcode;

public class FindMinimumInRotatedSortedArray {

  public int findMin(int[] nums) {

    int left = 0;
    int right = nums.length-1;

    while(nums[left] > nums[right]){
      int mid = (left+right) / 2;
      int numAtLeft = nums[left];
      int numAtMid = nums[mid];

      if(numAtLeft <= numAtMid){
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }

  public static void main(String[] args) {
    var fm = new FindMinimumInRotatedSortedArray();

    fm.findMin(new int[] {4, 5, 6, 7, 0, 1, 2});
  }
}
