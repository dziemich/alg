package crackingthecodeinterview.dp;

/*
Magic Index:
A magic index in an array A [e ... n -1] is defined to be an index such that A[ i] = i.
Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
FOLLOW UP What if the values are not distinct?
 */
public class Problem3 {


    public static int solve(int[] arr) {

        var left = 0;
        var mid = arr.length / 2;
        var right = arr.length - 1;

        while (left != mid && right != mid) {
            if (arr[mid] == mid) return mid;

            if (arr[mid] > mid) {
                right = mid;
                mid = (right + left) / 2;
            } else {
                left = mid;
                mid = (right + left) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        var arr = new int[]{-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(Problem3.solve(arr));
    }

}
