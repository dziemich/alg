package leetcode;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // prefix sum
        int[] t = new int[n];
        for (int[] b : bookings) {
            t[b[0] - 1] += b[2];
            if (b[1] < n) {
                t[b[1]] -= b[2];
            }
        }
        for (int i = 1; i < n; i++) {
            t[i] += t[i - 1];
        }
        return t;
    }

  public static void main(String[] args) {

        var cfb = new CorporateFlightBookings();

        cfb.corpFlightBookings(new int[][]{
                new int[]{1,2,10},
                new int[]{2,3,20},
                new int[]{2,5,25}
        }, 5);


  }
}
