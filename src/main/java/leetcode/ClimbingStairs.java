package leetcode;

public class ClimbingStairs {

    int[] results;

    public int climbStairs(int n) {
        results = new int[n];
        return helper(n);
    }

    public int helper(int n) {
        if (n == 1) {
            results[0] = 1;
        }
        else if (n == 2) {
            results[1] = 2;
        } else {
            results[n - 1] = helper(n - 2) + helper(n - 1);
        }
        return results[n - 1];
    }

    public static void main(String[] args) {
        var cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(15));
    }
}
