package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxAreaOfIslands {
  public int maxAreaOfIsland(int[][] grid) {

    int maxArea = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 0) continue;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});

        int localArea = 0;
        grid[i][j] = 0;

        while (!queue.isEmpty()) {
          int[] point = queue.poll();

          localArea++;

          int pointI = point[0];
          int pointJ = point[1];

          if (pointI > 0 && grid[pointI - 1][pointJ] == 1) {
            grid[pointI - 1][pointJ] = 0;
            queue.offer(new int[] {pointI - 1, pointJ});
          }

          if (pointI < grid.length - 1 && grid[pointI + 1][pointJ] == 1) {
            grid[pointI + 1][pointJ] = 0;
            queue.offer(new int[] {pointI + 1, pointJ});
          }

          if (pointJ > 0 && grid[pointI][pointJ - 1] == 1) {
            grid[pointI][pointJ - 1] = 0;
            queue.offer(new int[] {pointI, pointJ - 1});
          }

          if (pointJ < grid[0].length - 1 && grid[pointI][pointJ + 1] == 1) {
            grid[pointI][pointJ + 1] = 0;
            queue.offer(new int[] {pointI, pointJ + 1});
          }
        }

        maxArea = Math.max(localArea, maxArea);
      }
    }

    return maxArea;
  }

  public static void main(String[] args) {
    var maoi = new MaxAreaOfIslands();

    maoi.maxAreaOfIsland(
        new int[][] {
          new int[] {1, 1, 0, 0, 0},
          new int[] {1, 1, 0, 0, 0},
          new int[] {0, 0, 0, 1, 1},
          new int[] {0, 0, 0, 1, 1}
        });
  }
}
