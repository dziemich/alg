package crackingthecodeinterview.dp;

/*
Recursive Multiply:
Write a recursive function to multiply two positive integers without using the * operator.
You can use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
 */

public class Problem5 {

    public static int solve(int a, int b){
        return mul(a, b, 1, 0);
    }
    private static int mul(int a, int b, int level, int sum) {
        if (level == b){
            return sum + a;
        }
        return mul(a,b, level + 1, sum + a);
    }

    public static void main(String[] args) {
        System.out.println(Problem5.solve(3,6));
    }
}
