package leetcode;

import java.util.*;

public class NumberOfIslands {

  public int numIslands(char[][] grid) {

    int counter = 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          counter++;
          Queue<int[]> queue = new LinkedList<>();
          queue.add(new int[] {i, j});
          while (!queue.isEmpty()) {
            var cell = queue.remove();
            var c1 = cell[0];
            var c2 = cell[1];
            if (grid[c1][c2] == '1') {
              grid[c1][c2] = '0';

              if (c1 + 1 < grid.length && grid[c1 + 1][c2] == '1') {
                queue.add(new int[] {c1 + 1, c2});
              }
              if (c1 - 1 >= 0 && grid[c1 - 1][c2] == '1') {
                queue.add(new int[] {c1 - 1, c2});
              }
              if (c2 - 1 >= 0 && grid[c1][c2 - 1] == '1') {
                queue.add(new int[] {c1, c2 - 1});
              }
              if (c2 + 1 < grid[0].length && grid[c1][c2 + 1] == '1') {
                queue.add(new int[] {c1, c2 + 1});
              }
            }
          }
        }
      }
    }
    return counter;
  }

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    char[][] map = new char[m][n];

    List<Integer> result = new ArrayList<>();

    for (var pos : positions) {
      map[pos[0]][pos[1]] = '1';
      char[][] copy = deepCopy(map);
      result.add(numIslands(copy));
    }
    return result;
  }

  public int numIslandsClean(char[][] grid) {

    int num = 0;

    boolean[][] copy = new boolean[grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid.length; j++) {
        copy[i][j] = grid[i][j] == '1';
      }
    }

    for (int i = 0; i < copy.length; i++) {
      for (int j = 0; j < copy.length; j++) {
        if (copy[i][j]) {
            num++;

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{i,j});

            while (!queue.isEmpty()) {
              var cell = queue.remove();
              var c1 = cell[0];
              var c2 = cell[1];

              if (copy[c1][c2]) {
                copy[c1][c2] = false;

                if (c1 + 1 < copy.length && copy[c1 + 1][c2]) {
                  queue.add(new int[] {c1 + 1, c2});
                }
                if (c1 - 1 >= 0 && copy[c1 - 1][c2]) {
                  queue.add(new int[] {c1 - 1, c2});
                }
                if (c2 - 1 >= 0 && copy[c1][c2 - 1]) {
                  queue.add(new int[] {c1, c2 - 1});
                }
                if (c2 + 1 < copy[0].length && !copy[c1][c2 + 1]) {
                  queue.add(new int[] {c1, c2 + 1});
                }
              }
            }
          }
        }
      }
      return num;
  }

  public static void main(String[] args) {

    var noi = new NumberOfIslands();

    var input =
        new int[][] {
          new int[] {0, 0},
          new int[] {0, 1},
          new int[] {1, 2},
          new int[] {2, 1}
        };

    char[][] grid =
        new char[][] {
          new char[] {'1', '1', '1', '1', '0'},
          new char[] {'1', '1', '0', '1', '0'},
          new char[] {'1', '1', '0', '0', '0'},
          new char[] {'0', '0', '0', '0', '0'}
        };

    System.out.println(noi.numIslandsClean(grid));
  }

  private char[][] deepCopy(char[][] input) {
    return Arrays.stream(input).map(arr -> Arrays.copyOf(arr, arr.length)).toArray(char[][]::new);
  }
}
