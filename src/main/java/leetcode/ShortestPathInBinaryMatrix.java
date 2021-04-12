package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortestPathInBinaryMatrix {
  public int shortestPathBinaryMatrix(int[][] grid) {

    int m = grid.length;
    if (grid[0][0] != 0 || grid[m - 1][m - 1] == 1) return -1;

    int[][] directions =
        new int[][] {
          new int[] {-1, -1},
          new int[] {-1, 0},
          new int[] {-1, 1},
          new int[] {0, -1},
          new int[] {0, 1},
          new int[] {1, -1},
          new int[] {1, 0},
          new int[] {1, 1}
        };

    boolean[][] visited = new boolean[m][m];

    // dijkstra

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));

    pq.offer(new int[] {1, 0, 0});
    visited[0][0] = true;

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      int score = curr[0];
      int i = curr[1];
      int j = curr[2];

      if (i == m - 1 && j == m - 1) return score;

      for (int[] dir : directions) {
        int newI = i + dir[0];
        int newJ = j + dir[1];

        if (newI < 0 || newI >= m || newJ < 0 || newJ >= m) continue;
        if (!visited[newI][newJ] && grid[newI][newJ] == 0) {
          visited[newI][newJ] = true;
          pq.offer(new int[] {score + 1, newI, newJ});
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    var spibm = new ShortestPathInBinaryMatrix();

    int i = spibm.shortestPathBinaryMatrix(
            new int[][]{
                    new int[]{0, 0, 0},
                    new int[]{0, 0, 0},
                    new int[]{0, 0, 0}
            });
    System.out.println("D: " + i);
  }
}
