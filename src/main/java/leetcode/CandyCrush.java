package leetcode;

import java.util.*;

public class CandyCrush {

  int[][] b;

  public int[][] candyCrush(int[][] board) {

    b = board;
    boolean canCrush = true;
    do {
      crush();
      gravity();
      canCrush = check();
    } while (canCrush);

    return board;
  }

  boolean check() {
    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        int v = b[i][j];
        if (v == 0) continue;

        if (i < b.length - 2 && (b[i + 1][j] == v && b[i + 2][j] == v)) return true;

        if (j < b[0].length - 2 && (b[i][j + 1] == v && b[i][j + 2] == v)) return true;
      }
    }
    return false;
  }

  void gravity() {
    for (int j = 0; j < b[0].length; j++) {
      int storeInd = b.length - 1;
      for (int i = b.length - 1; i >= 0; i--) {
        if (b[i][j] > 0) {
          b[storeInd--][j] = b[i][j];
        }
      }
      for (int k = storeInd; k >= 0; k--) b[k][j] = 0;
    }
  }

  void crush() {
    Set<int[]> deletion = new HashSet<>();
    for (int i = 0; i < b.length; i++) {
      for (int j = 0; j < b[0].length; j++) {
        int v = b[i][j];
        if (v == 0) continue;

        if (i < b.length - 2) {
          if (b[i + 1][j] == v && b[i + 2][j] == v) {
            deletion.add(new int[] {i, j});
            deletion.add(new int[] {i + 1, j});
            deletion.add(new int[] {i + 2, j});
            int it = 3;
            while (i + it < b.length && b[i + it][j] == v) {
              deletion.add(new int[] {i + it, j});
              ++it;
            }
          }
        }

        if (j < b[0].length - 2) {
          if (b[i][j + 1] == v && b[i][j + 2] == v) {
            deletion.add(new int[] {i, j});
            deletion.add(new int[] {i, j + 1});
            deletion.add(new int[] {i, j + 2});
            int it = 3;
            while (j + it < b[0].length && b[i][j + it] == v) {
              deletion.add(new int[] {i, j + it});
              ++it;
            }
          }
        }
      }
    }
    for (int[] d : deletion) {
      b[d[0]][d[1]] = 0;
    }
  }

  public static void main(String[] args) {
    var cc = new CandyCrush();

    var board =
        new int[][] {
          new int[] {110, 5, 112, 113, 114},
          new int[] {110, 211, 5, 213, 214},
          new int[] {110, 110, 110, 313, 314},
        };

    var b2 =
        new int[][] {
          new int[] {110, 5, 112, 113, 114},
          new int[] {210, 211, 5, 213, 214},
          new int[] {310, 311, 3, 313, 314},
          new int[] {410, 411, 412, 5, 414},
          new int[] {5, 1, 512, 3, 3},
          new int[] {610, 4, 1, 613, 614},
          new int[] {710, 1, 2, 713, 714},
          new int[] {810, 1, 2, 1, 1},
          new int[] {1, 1, 2, 2, 2},
          new int[] {4, 1, 4, 4, 101}
        };

    cc.candyCrush(board);
    System.out.println("DONE");
  }
}
