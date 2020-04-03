package crackingthecodeinterview.graphs;

import crackingthecodeinterview.graphs.helpers.BinaryNode;
import crackingthecodeinterview.graphs.helpers.BinaryTree;
import crackingthecodeinterview.graphs.helpers.Node;

public class Problem2 {

    public BinaryTree<Integer> solve(int[] sortedArray){
        int mid = sortedArray.length / 2;

        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.accept(new BinaryNode<Integer>(sortedArray[mid]), Integer::compare);

        for (int i = 1; i <= sortedArray.length / 2; i++){
            tree.accept(new BinaryNode<Integer>(sortedArray[mid + i]), Integer::compare);
            tree.accept(new BinaryNode<Integer>(sortedArray[mid - i]), Integer::compare);
        }

        return tree;
    }

//    private BinaryTree solveHalf(int[] sortedArray){
//        BinaryTree<Integer> tree = new BinaryTree<>();
//        if (sortedArray.length == 1) {
//            tree.accept();
//            return
//        }
//    }
//
//    public BinaryTree solve2(int[] sortedArray){
//
//    }

    public static void main(String[] args) {
        Problem2 p2 = new Problem2();
        var tree = p2.solve(new int[]{2,4,6,8,9});
//        System.out.println("DONE");
    }
}
