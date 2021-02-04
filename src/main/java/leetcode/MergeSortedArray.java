package leetcode;

public class MergeSortedArray {
  public void merge(int[] nums1, int m, int[] nums2, int n) {

    int[] helper = new int[m + n];

    int it1 = 0;
    int it2 = 0;

    while (it1 < m || it2 < n) {
      if (it1 < m && nums1[it1] < nums2[it2]) {
        helper[Math.min(it1+it2, m+n-1)] = nums1[it1];
        ++it1;
      } else {
        helper[Math.min(it1+it2, m+n-1)] = nums2[it2];
        ++it2;
      }
    }

    System.arraycopy(helper, 0, nums1, 0, nums1.length);
    nums1 = helper;
  }

  public static void main(String[] args) {
    var msa = new MergeSortedArray();

    int m = 3;
    int n = 3;
    int[] nums1 = new int[]{1,2,3};
    int[] nums2 = new int[]{2,5,6};
    msa.merge(nums1, m, nums2, n);
    System.out.println("DONE");
  }
}
