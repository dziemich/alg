package leetcode;

public class MaxIncToKeepCitySkyline {
  public int maxIncreaseKeepingSkyline(int[][] grid) {

    int[] maxCol = new int[grid.length];
    int[] maxRow = new int[grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        int v = grid[i][j];
        maxCol[i] = Math.max(maxCol[i], v);
        maxRow[j] = Math.max(maxRow[j], v);
      }
    }

    int output = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        int v = grid[i][j];
        int add = Math.min(maxCol[i], maxRow[j]) - v;
        output += add;
      }
    }

    return output;
  }

  public static void main(String[] args) {
    var mitkcs = new MaxIncToKeepCitySkyline();

    int res =
        mitkcs.maxIncreaseKeepingSkyline(
            new int[][] {
              new int[] {3, 0, 8, 4},
              new int[] {2, 4, 5, 7},
              new int[] {9, 2, 6, 3},
              new int[] {0, 3, 1, 0}
            });
    System.out.println(res);
  }
}
