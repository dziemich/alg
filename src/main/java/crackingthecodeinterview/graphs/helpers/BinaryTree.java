package crackingthecodeinterview.graphs.helpers;

import java.util.Comparator;

public class BinaryTree<T> {
    private BinaryNode<T> head;

    public void accept(Node<T> n, Comparator<T> comparator){
        BinaryNode<T> currentNode = head;
        if(head == null) {
            head = new BinaryNode<T>(n.val, null, null);
            return;
        }
        while (true){
            if (comparator.compare(n.val, currentNode.val) < 0){
                if (currentNode.left == null){
                    currentNode.left = new BinaryNode<>(n.val, null, null);
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null){
                    currentNode.right = new BinaryNode<>(n.val, null, null);
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }
//
//    public void accept(BinaryTree<T> subtree, Comparator<T> comparator){
//        if (subtree.head)
//    }

}
