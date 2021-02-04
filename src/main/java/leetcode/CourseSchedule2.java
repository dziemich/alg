package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class CourseSchedule2 {
  public int[] findOrder(int numCourses, int[][] prerequisites) {

    Map<Integer, Set<Integer>> graph = new HashMap<>();

    for (int i = 0; i < numCourses; i++) {
      graph.put(i, new HashSet<>());
    }

    for (int[] pr : prerequisites) {
      Set<Integer> s = graph.get(pr[1]);
      s.add(pr[0]);
      graph.put(pr[1], s);
    }

    Set<Integer> leaves =
        graph.keySet().stream().filter(c -> graph.get(c).size() == 0).collect(Collectors.toSet());

    List<Integer> res = new ArrayList<>();

    while (res.size() < numCourses) {

      for (var leaf : leaves) {
        res.add(leaf);
        for (var node : graph.values()) {
          node.remove(leaf);
        }
        graph.remove(leaf);
      }

      leaves =
          graph.keySet().stream().filter(c -> graph.get(c).size() == 0).collect(Collectors.toSet());
    }

    int[] output = new int[numCourses];

    for (int i = 0; i < numCourses; i++) output[i] = res.get(i);
    return output;
  }

  public static void main(String[] args) {
    var cs2 = new CourseSchedule2();

    cs2.findOrder(2, new int[][] {new int[] {0,1}});
  }
}
