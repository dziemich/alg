package leetcode;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = (left + right) / 2 + 1;
            int rm = nums[mid];

            if(rm == target) return mid;
            else if(rm < target){
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }

  public static void main(String[] args) {
    var sira = new SearchInRotatedSortedArray();

    sira.search(new int[]{4,5,6,7,0,1,2}, 3);

  }
}
