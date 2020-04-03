package crackingthecodeinterview.dp;

/*
Towers of Hanoi:
In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes
which can slide onto any tower. The puzzle starts with disks sorted in ascending order of size
from top to bottom (Le., each disk sits on top of an even larger one). You have the following constraints:
(1) Only one disk can be moved at a time.
(2) A disk is slid off the top of one tower onto another tower.
(3) A disk cannot be placed on top of a smaller disk.
Write a program to move the disks from the first tower to the last using stacks.
 */

import java.util.Stack;

public class Problem6 {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();
    private Stack<Integer> C = new Stack<>();

    public void solve(int n) {
        for (int i = n; i >= 1; i--) {
            A.push(i);
        }
        towers(n, A, B, C);
        for (int i = 0; i < n; i++){
            System.out.println("platform: " + B.pop());
        }
    }

    private void towers(int n, Stack<Integer> src, Stack<Integer> dest, Stack<Integer> aux){
        if (n == 2){
            moveToStack(src, aux);
            moveToStack(src, dest);
            moveToStack(aux, dest);
            return;
        }
        towers(n-1, src, aux, dest);
        moveToStack(src, dest);
        towers(n-1, aux, dest, src);
    }

    private void moveToStack(Stack<Integer> src, Stack<Integer> dest){
        Integer last = src.pop();
        dest.push(last);
    }

    public static void main(String[] args) {
        Problem6 p6 = new Problem6();

        int n = 4;
        p6.solve(n);
    }
}
