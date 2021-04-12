package leetcode;

import java.util.*;

public class IsGraphBipartite {
  public boolean isBipartite(int[][] graph) {

    int[] groups = new int[graph.length];

    for (int i = 0; i < groups.length; i++) {

      if (groups[i] != 0) continue;

      Queue<Integer> q = new LinkedList<>();
      groups[i] = -1;

      q.offer(i);

      while (!q.isEmpty()) {
        var curr = q.poll();

        for (int vert : graph[curr]) {

          if (groups[vert] == 0) {
            groups[vert] = -groups[curr];
            q.offer(vert);
          } else if(groups[vert] == groups[curr]){
            return false;
          }
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    var input =
        new int[][] {
          new int[] {1, 3},
          new int[] {0, 2},
          new int[] {1, 3},
          new int[] {0, 2}
        };
    // [[1],[0,3],[3],[1,2]]

    /*
    0 - 1 - 3 - 2
     */
    var input2 = new int[][] {new int[] {1}, new int[] {0, 3}, new int[] {3}, new int[] {1, 2}};

    var igb = new IsGraphBipartite();

    System.out.println(igb.isBipartite(input2));
  }
}
