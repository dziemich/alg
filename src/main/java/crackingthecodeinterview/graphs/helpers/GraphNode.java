package crackingthecodeinterview.graphs.helpers;

public class GraphNode<T> extends Node<T>{
    public GraphNode<T>[] children;

    public GraphNode(T val, GraphNode<T>[] children) {
        super(val);
        this.children = children;
    }
}
