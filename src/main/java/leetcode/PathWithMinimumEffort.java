package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
  //  int min = Integer.MAX_VALUE;
  //
  //  public int minimumEffortPath(int[][] heights) {
  //    min = Integer.MAX_VALUE;
  //    boolean[][] visited = new boolean[heights.length][heights[0].length];
  //    dfs(visited, heights, 0, 0, 0);
  //    return min;
  //  }
  //
  //  void dfs(boolean[][] visited, int[][] heights, int row, int col, int local) {
  //    if (local > min) return;
  //    if (row == heights.length - 1 && col == heights[0].length - 1) {
  //      min = local;
  //      return;
  //    }
  //    visited[row][col] = true;
  //    boolean[][] copy = new boolean[heights.length][heights[0].length];
  //
  //    for (int i = 0; i < visited.length; i++) {
  //      System.arraycopy(visited[i], 0, copy[i], 0, visited[0].length);
  //    }
  //
  //    if (row > 0) {
  //      if (!visited[row - 1][col])
  //        dfs(
  //            copy,
  //            heights,
  //            row - 1,
  //            col,
  //            Math.max(local, Math.abs(heights[row][col] - heights[row - 1][col])));
  //    }
  //    if (col > 0) {
  //      if (!visited[row][col - 1])
  //        dfs(
  //            copy,
  //            heights,
  //            row,
  //            col - 1,
  //            Math.max(local, Math.abs(heights[row][col] - heights[row][col - 1])));
  //    }
  //    if (col < heights[0].length - 1) {
  //      if (!visited[row][col + 1])
  //        dfs(
  //            copy,
  //            heights,
  //            row,
  //            col + 1,
  //            Math.max(local, Math.abs(heights[row][col] - heights[row][col + 1])));
  //    }
  //
  //    if (row < heights.length - 1) {
  //      if (!visited[row + 1][col])
  //        dfs(
  //            copy,
  //            heights,
  //            row + 1,
  //            col,
  //            Math.max(local, Math.abs(heights[row][col] - heights[row + 1][col])));
  //    }
  //  }
  //

  public int minimumEffortPath(int[][] heights) {
    int[][] directions =
        new int[][] {new int[] {1, 0}, new int[] {-1, 0}, new int[] {0, 1}, new int[] {0, -1}};

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(i -> i[0]));
    pq.offer(new int[] {0, 0, 0});

    Integer[][] distances = new Integer[heights.length][heights[0].length];
    distances[0][0] = 0;

    while (!pq.isEmpty()) {
      var top = pq.poll();

      int row = top[1];
      int col = top[2];

      if (row == heights.length - 1 && col == heights[0].length - 1) {
        return top[0];
      }

      for (int[] dir : directions) {
        int nextRow = row + dir[0];
        int nextCol = col + dir[1];

        if (nextRow == -1
            || nextRow == heights.length
            || nextCol == -1
            || nextCol == heights[0].length) continue;

        int distance = Math.max(top[0], Math.abs(heights[row][col] - heights[nextRow][nextCol]));

        if (distances[nextRow][nextCol] == null || distance < distances[nextRow][nextCol]) {
          distances[nextRow][nextCol] = distance;
          pq.offer(new int[] {distance, nextRow, nextCol});
        }
      }
    }
    return -1;
  }


  public static void main(String[] args) {
    var pwme = new PathWithMinimumEffort();

    int i =
        pwme.minimumEffortPath(
            new int[][] {
              new int[] {1, 2, 2},
              new int[] {3, 8, 2},
              new int[] {5, 3, 5}
            });
    System.out.println("DONE" + i);
  }
}
