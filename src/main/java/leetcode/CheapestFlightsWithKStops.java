package leetcode;

import java.util.*;

public class CheapestFlightsWithKStops {

  int lowestCost = Integer.MAX_VALUE;

  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    lowestCost = Integer.MAX_VALUE;
    Map<Integer, List<int[]>> connections = new HashMap<>();

    for (int[] flight : flights) {
      var list = connections.getOrDefault(flight[0], new ArrayList<>());
      list.add(new int[] {flight[1], flight[2]});
      connections.put(flight[0], list);
    }
    dfs(src, dst, 0, -1, K, connections);
    return lowestCost == Integer.MAX_VALUE ? -1 : lowestCost;
  }

  void dfs(
      int src, int dst, int cost, int changes, int limit, Map<Integer, List<int[]>> connections) {

    if (changes > limit) return;

    if (src == dst) {
      lowestCost = Math.min(lowestCost, cost);
      return;
    }

    connections
        .getOrDefault(src, new ArrayList<>())
        .forEach(conn -> dfs(conn[0], dst, cost + conn[1], changes + 1, limit, connections));
  }

  public static void main(String[] args) {
    var cfks = new CheapestFlightsWithKStops();

    System.out.println(
        cfks.findCheapestPrice(
            3,
            new int[][] {
              new int[] {0, 1, 100},
              new int[] {1, 2, 100},
              new int[] {0, 2, 500}
            },
            0,
            2,
            1));

    System.out.println(
        cfks.findCheapestPrice(
            3,
            new int[][] {
              new int[] {0, 1, 100},
              new int[] {1, 2, 100},
              new int[] {0, 2, 500}
            },
            0,
            2,
            0));
  }
}
