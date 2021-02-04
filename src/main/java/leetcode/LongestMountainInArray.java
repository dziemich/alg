package leetcode;

public class LongestMountainInArray {
  public int longestMountain(int[] A) {

    if (A.length <=1) return 0;

    int previousTrend = 0;
    int previousCounter = 0;
    int currentTrend = 0;
    int currentCounter = 2;
    int max = 0;
    if (A[0] > A[1]) {
      currentTrend = -1;
    } else if (A[0] < A[1]) {
      currentTrend = 1;
    }

    for (int i = 2; i < A.length; i++) {
      if (A[i - 1] > A[i]) {
        if (currentTrend == -1) {
          currentCounter++;
        } else {
          previousCounter = currentCounter;
          previousTrend = currentTrend;
          currentCounter = 2;
          currentTrend = -1;
        }
      } else if (A[i - 1] < A[i]) {
        if (currentTrend == 1) {
          currentCounter++;
        } else {
          if (previousTrend == 1 && currentTrend == -1) {
            max = Math.max(max, currentCounter + previousCounter - 1);
          }
          previousCounter = currentCounter;
          previousTrend = currentTrend;
          currentCounter = 2;
          currentTrend = 1;
        }
      } else {
        if (currentTrend == 0) {
          currentCounter = 1;
        } else {
          if (currentTrend == -1) {
            max = Math.max(max, currentCounter + previousCounter - 1);
          }
          previousCounter = currentCounter;
          previousTrend = currentTrend;
          currentCounter = 1;
          currentTrend = 0;
        }
      }
    }

    if (previousTrend == 1 && currentTrend == -1) {
      max = Math.max(max, currentCounter + previousCounter - 1);
    }

    return max;
  }

  public static void main(String[] args) {
    var lmia = new LongestMountainInArray();

    System.out.println(
        "should be 5: " + lmia.longestMountain(new int[] {7,4,8}));
  }
}
