package leetcode;

import java.util.*;

/*
https://leetcode.com/problems/course-schedule/
 */

public class CourseSchedule {
    public class Graph {
        int size;
        Vert[] vertices;

        public Graph(int size) {
            this.size = size;
            vertices = new Vert[size];
        }

        public void buildFromEdges(int[][] edges) {
            for (int i = 0; i < size; i++) {
                vertices[i] = new Vert(i, new ArrayList<>());
            }
            for (int[] edge : edges) {
                vertices[edge[0]].adjacent.add(vertices[edge[1]]);
            }
        }
    }

    public class Vert {
        public int val;
        public List<Vert> adjacent = new ArrayList<>();
        public boolean alreadyVisited = false;

        public Vert(int val, List<Vert> adjacent) {
            this.val = val;
            this.adjacent = adjacent;
            alreadyVisited = false;
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var graph = new Graph(numCourses);
        graph.buildFromEdges(prerequisites);

        for (int i = 0; i < numCourses; i++) {
            if (dfs(graph.vertices[i], new boolean[numCourses], new boolean[numCourses])) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Vert vert, boolean[] visited, boolean[] stack) {
        if (stack[vert.val]) return true;
        if (visited[vert.val]) return false;
        visited[vert.val] = true;
        stack[vert.val] = true;

        for (var v : vert.adjacent) {
            if (dfs(v, visited, stack)) return true;
        }

        stack[vert.val] = false;
        return false;

    }
}
