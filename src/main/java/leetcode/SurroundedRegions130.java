package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SurroundedRegions130 {
  public void solve(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'O') {
          var queue = new LinkedList<int[]>();
          var visited = new ArrayList<String>();
          visited.add(i + "," + j);
          queue.add(new int[] {i, j});

          while (!queue.isEmpty()) {
            var o = queue.remove();
            int oi = o[0];
            int oj = o[1];
            if (oi == 0 || oj == 0 || oi == board.length - 1 || oj == board[0].length - 1) continue;

            boolean isSurrounded =
                Stream.of(
                        new int[] {oi + 1, oj},
                        new int[] {oi - 1, oj},
                        new int[] {oi, oj + 1},
                        new int[] {oi, oj - 1})
                    .allMatch(
                        pair ->
                            board[pair[0]][pair[1]] == 'X'
                                || visited.contains(pair[0] + "," + pair[1]));

            if (isSurrounded) board[oi][oj] = 'X';


            if (board[oi + 1][oj] == 'O') {
              if (oi < board.length - 2) {
                System.out.println("C1");

                queue.add(new int[] {oi + 1, oj});
                visited.add((oi + 1) + "," + oj);
              }
            }

            if (board[oi - 1][oj] == 'O') {
              if (oi > 1) {
                System.out.println("C2");

                queue.add(new int[] {oi - 1, oj});
                visited.add((oi - 1) + "," + oj);
              }
            }
            if (board[oi][oj + 1] == 'O') {
              if (oj < board[0].length - 2) {
                System.out.println("C3");
                queue.add(new int[] {oi, oj + 1});
                visited.add(oi + "," + (oj + 1));
              }
            }
            if (board[oi][oj - 1] == 'O') {
              if (oj > 1) {
                System.out.println("C4");
                queue.add(new int[] {oi, oj - 1});
                visited.add(oi + "," + (oj - 1));
              }
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    var sr130 = new SurroundedRegions130();

    var board =
        new char[][] {
          new char[] {'O', 'X', 'X', 'O', 'X'},
          new char[] {'X', 'O', 'O', 'X', 'O'},
          new char[] {'X', 'O', 'X', 'O', 'X'},
          new char[] {'O', 'X', 'O', 'O', 'O'},
          new char[] {'X', 'X', 'O', 'X', 'O'}
        };

    sr130.solve(board);
    System.out.println("DONE");
  }
  public int numRescueBoats(int[] people, int limit) {
    int sumWeight = Arrays.stream(people).boxed().reduce(0,Integer::sum);
    System.out.println(sumWeight);
    return (int) Math.ceil(((double) sumWeight) / limit);
  }
}
