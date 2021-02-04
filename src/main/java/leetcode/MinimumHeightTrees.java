package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinimumHeightTrees {
  public List<Integer> findMinHeightTrees2(int n, int[][] edges) {

    int[] connections = new int[n];

    Set<Integer> nodes = new HashSet<>();

    for (int[] edge : edges) {
      connections[edge[0]]++;
      connections[edge[1]]++;
      nodes.add(edge[0]);
      nodes.add(edge[1]);
    }

    var list = Arrays.stream(new int[] {1, 2, 3}).boxed().collect(Collectors.toList());

    while (nodes.size() >= 2) {
      int min = list.get(0);
      List<Integer> toBeRemoved = new ArrayList<>();

      for (int i : list) {
        if (i < min) {
          toBeRemoved = List.of(i);
        } else if (i == min) {
          toBeRemoved.add(i);
        }
      }
      nodes.remove(toBeRemoved);
    }
    return List.of();
  }

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {

    ArrayList<Set<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      graph.add(new HashSet<Integer>());
    }

    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }

    List<Integer> leafIndices = new ArrayList<>();
    int nodes = n;

    for (int i = 0; i < n; i++) {
      if (graph.get(i).size() == 1) leafIndices.add(i);
    }

    while (nodes > 2) {
      nodes -= leafIndices.size();
      List<Integer> nextLeaves = new ArrayList<>();

      for (int index : leafIndices) {
        Integer neighbor = graph.get(index).iterator().next();
        graph.get(index).remove(neighbor);
        graph.get(neighbor).remove(index);

        if (graph.get(neighbor).size() == 1) nextLeaves.add(neighbor);
      }

      leafIndices = nextLeaves;
    }
    return leafIndices;
  }

  public static void main(String[] args) {
    var mht = new MinimumHeightTrees();

    mht.findMinHeightTrees(4, new int[][] {new int[] {1, 0}, new int[] {1, 2}, new int[] {1, 3}});
  }
}
