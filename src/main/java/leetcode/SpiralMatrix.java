package leetcode;

public class SpiralMatrix {
  public int[][] generateMatrix(int n) {
    int i, k = 0, l = 0;
    int[][] ret = new int[n][n];
    int row = n;
    int col = n;

    int counter = 0;

    while (k < row && l < col) {
      for (i = l; i < col; ++i) {
        ret[k][i] = ++counter;
      }
      k++;

      for (i = k; i < row; ++i) {
        ret[i][col - 1] = ++counter;
      }
      col--;

      if (k < row) {
        for (i = col - 1; i >= l; --i) {
          ret[row - 1][i] = ++counter;
        }
        row--;
      }

      if (l < col) {
        for (i = row - 1; i >= k; --i) {
          ret[i][l] = ++counter;
        }
        l++;
      }
    }

    return ret;
  }
}
