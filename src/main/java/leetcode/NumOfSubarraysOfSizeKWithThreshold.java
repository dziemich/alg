package leetcode;

public class NumOfSubarraysOfSizeKWithThreshold {
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    if (arr.length < k) {
      return 0;
    }
    int counter = 0;
    int sum = 0;

    for (int i = 0; i < k; i++) {
      sum += arr[i];
    }
    double fmean = (double) sum / (double) k;
    if (fmean >= threshold) counter++;

    for (int i = k; i < arr.length; i++) {
      sum = sum + arr[i] - arr[i - k];

      double mean = (double) sum / (double) k;
      if (mean >= threshold) counter++;
    }
    return counter;
  }

  public static void main(String[] args) {
    var num = new NumOfSubarraysOfSizeKWithThreshold();

    num.numOfSubarrays(new int[] {11, 13, 17, 23, 29, 31, 7, 5, 2, 3}, 3, 5);
  }
}
