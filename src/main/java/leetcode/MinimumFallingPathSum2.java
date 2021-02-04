package leetcode;

public class MinimumFallingPathSum2 {

  public int minFallingPathSum(int[][] arr) {

    int length = arr.length;
    if (length == 1) return arr[0][0];

    int[] last = new int[length];

    for (int i = 1; i <= length; i++) {

      int[] row = new int[length];

      for(int j = 0; j < length; j++){

        int localMin = Integer.MAX_VALUE;

        for(int k = 0; k < length; k++){
          if(k==j) continue;

          localMin = Math.min(localMin, last[k]);
        }

        row[j] = localMin;
      }

      last = row;
    }

    int min = Integer.MAX_VALUE;

    for (int i = 0; i < length; i++) {
      min = Math.min(min, last[i]);
    }

    return min;
  }

  public static void main(String[] args) {

    int[][] arr =
        new int[][] {
          new int[] {-73, 61, 43, -48, -36},
          new int[] {  3, 30, 27,  57,  10},
          new int[] {96, -76, 84, 59, -15},
          new int[] {5, -49, 76, 31, -7},
          new int[] {97, 91, 61, -46, 6}
        };

    var mfps2 = new MinimumFallingPathSum2();

    mfps2.minFallingPathSum(arr);
  }
}
