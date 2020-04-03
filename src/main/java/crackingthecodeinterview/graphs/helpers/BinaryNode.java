package crackingthecodeinterview.graphs.helpers;

public class BinaryNode<T> extends Node<T> {
    public BinaryNode<T> left, right;

    public BinaryNode() {
        super();
    }

    public BinaryNode(T val) {
        super(val);
        this.left = null;
        this.right = null;
    }

    public BinaryNode(T val, BinaryNode<T> left, BinaryNode<T> right) {
        super(val);
        this.left = left;
        this.right = right;
    }
}
