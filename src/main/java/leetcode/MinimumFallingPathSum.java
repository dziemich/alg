package leetcode;

public class MinimumFallingPathSum {

  public int minFallingPathSum(int[][] A) {
    int length = A.length;
    if(length == 1) return A[0][0];
    int min = Integer.MAX_VALUE;
    int[] last = new int[length];

    for (int i = 1; i <= length; i++) {

      int[] row = new int[length];

      for (int j = 0; j < length; j++) {

        if (j == 0) {
          row[j] = Math.min(last[j], last[j + 1]) + A[i - 1][j];
        } else if (j == length - 1) {
          row[j] = Math.min(last[j - 1], last[j]) + A[i - 1][j];
        } else {
          row[j] = Math.min(last[j - 1], Math.min(last[j], last[j + 1])) + A[i - 1][j];
        }
      }
      last = row;
    }
    for(int i: last){
      min = Math.min(i, min);
    }
    return min;
  }

  public static void main(String[] args) {
    var mfps = new MinimumFallingPathSum();

    mfps.minFallingPathSum(
        new int[][] {
          new int[] {1, 2, 3},
          new int[] {4, 5, 6},
          new int[] {7, 8, 9}
        });
    //
  }
}
