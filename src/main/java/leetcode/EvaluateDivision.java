package leetcode;

import java.util.*;

public class EvaluateDivision {

  static class Edge {

    String target;
    double value;

    public Edge(String target, double value) {
      this.target = target;
      this.value = value;
    }
  }

  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {

    HashMap<String, Set<Edge>> graph = new HashMap<>();

    for (int i = 0; i < values.length; i++) {

      List<String> eq = equations.get(i);

      String var1 = eq.get(0);
      String var2 = eq.get(1);

      double val = values[i];

      Set<Edge> edges1 = graph.getOrDefault(var1, new HashSet<>());
      edges1.add(new Edge(var2, val));
      graph.put(var1, edges1);

      Set<Edge> edges2 = graph.getOrDefault(var2, new HashSet<>());
      edges2.add(new Edge(var1, 1 / val));
      graph.put(var2, edges2);
    }

    double[] result = new double[queries.size()];

    for (int i = 0; i < result.length; i++) {

      HashSet<String> visited = new HashSet<>();
      List<String> query = queries.get(i);

      result[i] = dfs(query.get(0), query.get(1), graph, visited, 1.0d);
    }

    return result;
  }

  double dfs(
      String start,
      String target,
      HashMap<String, Set<Edge>> graph,
      HashSet<String> visited,
      double acc) {

    if (start.equals(target)) return acc;
    visited.add(start);
    double ret = -1.0;

    for (Edge e : graph.get(start)) {
      if (!visited.contains(e.target)) {
        ret = dfs(e.target, target, graph, visited, acc * e.value);
      }
      if (ret != -1.0) break;
    }
    visited.remove(start);
    return ret;
  }

  public static void main(String[] args) {
    var ed = new EvaluateDivision();

    double[] doubles =
        ed.calcEquation(
            List.of(List.of("a", "b"), List.of("b", "c")),
            new double[] {2, 4},
            List.of(List.of("a", "c")));
    System.out.println("DONE");
  }
}
