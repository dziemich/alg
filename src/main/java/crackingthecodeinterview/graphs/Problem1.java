package crackingthecodeinterview.graphs;

/*
Route Between Nodes:
Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

import crackingthecodeinterview.graphs.helpers.Graph;
import crackingthecodeinterview.graphs.helpers.GraphNode;
import crackingthecodeinterview.graphs.helpers.NodeState;

import java.util.LinkedList;
import java.util.function.Consumer;

public class Problem1 {

    private boolean pathFound;

    public void solveDFS(Graph g, GraphNode n1, GraphNode n2, Consumer<GraphNode> visit) {
        pathFound = false;
        dfs(g, n1, n2, visit);
        System.out.println("Path found ".concat(String.valueOf(pathFound)));
    }

    public boolean solveBFS(Graph g, GraphNode n1, GraphNode n2, Consumer<GraphNode> visit) {
        LinkedList<GraphNode> queue = new LinkedList<>();

        n1.nodeState = NodeState.VISITED;
        visit.accept(n1);
        queue.add(n1);
        while (!queue.isEmpty()) {
            var n = queue.removeFirst();
            for (var child : n.children) {
                if (child.equals(n2)) return true;
                if (child.nodeState == NodeState.UNVISITED) {
                    visit.accept(child);
                    child.nodeState = NodeState.VISITED;
                    queue.add(child);
                }
            }
        }
        return false;
    }

    private void dfs(Graph graph, GraphNode n1, GraphNode n2, Consumer<GraphNode> visit) {
        if (pathFound) return;

        visit.accept(n1);
        n1.nodeState = NodeState.VISITED;
        for (var n : n1.children) {
            if (n == n2) {
                pathFound = true;
            }
            if (n.nodeState == NodeState.UNVISITED) {
                dfs(graph, n, n2, visit);
            }
        }
    }

    public static void main(String[] args) {
        GraphNode n1 = new GraphNode("1", new GraphNode[]{});
        GraphNode n2 = new GraphNode("2", new GraphNode[]{});
        GraphNode n3 = new GraphNode("3", new GraphNode[]{});
        GraphNode n4 = new GraphNode("4", new GraphNode[]{});
        GraphNode n5 = new GraphNode("5", new GraphNode[]{});

        n1.children = new GraphNode[]{n2};
        n2.children = new GraphNode[]{n1, n3, n5};
        n3.children = new GraphNode[]{n2};
        n4.children = new GraphNode[]{n5};
        n5.children = new GraphNode[]{n2, n4};

        Graph g = new Graph(new GraphNode[]{n1, n2, n3, n4, n5});

        Problem1 p1 = new Problem1();

        p1.solveDFS(
                g,
                n1,
                n4,
                n -> System.out.println("Visiting node: ".concat((String) n.val))
        );

        System.out.println(p1.solveBFS(
                g,
                n1,
                n4,
                n -> System.out.println("Visiting node: ".concat((String) n.val))
        ));

    }

}
