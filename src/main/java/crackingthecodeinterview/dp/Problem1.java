package crackingthecodeinterview.dp;

/*
Triple Step:
A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
Implement a method to count how many possible ways the child can run up the stairs.
 */

public class Problem1 {
    int[] memo;

    private int solveTripleStep(int n) {
        int res = 0;

        if (memo[n - 1] != 0) return memo[n-1];

        if (n == 1) {
            res = 1;
        } else if (n == 2) {
            res = 2;
        } else if (n == 3) {
            res = 4;
        } else {
            res = solveTripleStep(n - 3) + solveTripleStep(n - 2) + solveTripleStep(n - 1);
        }
        memo[n - 1] = res;
        return res;
    }

    int solve(int n) {
        memo = new int[n];
        return solveTripleStep(n);
    }

    public static void main(String[] args) {
        System.out.println("Testcase: ".concat(String.valueOf(new Problem1().solve(1))).concat(String.valueOf((new Problem1().solve(1) == 1))));
        System.out.println("Testcase: ".concat(String.valueOf(new Problem1().solve(2))).concat(String.valueOf((new Problem1().solve(2) == 2))));
        System.out.println("Testcase: ".concat(String.valueOf(new Problem1().solve(3))).concat(String.valueOf((new Problem1().solve(3) == 4))));
        System.out.println("Testcase: ".concat(String.valueOf(new Problem1().solve(4))).concat(String.valueOf((new Problem1().solve(4) == 7))));
        System.out.println("Testcase: ".concat(String.valueOf(new Problem1().solve(5))).concat(String.valueOf((new Problem1().solve(5) == 13))));
    }
}
