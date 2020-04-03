package crackingthecodeinterview.graphs.helpers;

import java.util.Objects;

public abstract class Node<T> {
    public T val;
    public NodeState nodeState;

    public Node() {
        nodeState = NodeState.UNVISITED;
    }

    public Node(T val) {
        this();
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return val.equals(node.val);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
