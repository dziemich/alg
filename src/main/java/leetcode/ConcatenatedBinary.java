package leetcode;

public class ConcatenatedBinary {

    public int concatenatedBinary(int n) {
        int sum = 1;
        int div = (int) ((int) Math.pow(10, 9) + 7.0);

        for(int i = 2; i <= n ; i++){
            long mul = (long) (sum * Math.pow(2, Integer.toBinaryString(n).length()));
            mul += n;
            sum = (int) (mul % div);
        }
        return sum;
    }

  public static void main(String[] args) {
    var cb = new ConcatenatedBinary();
    cb.concatenatedBinary(3);
  }
}
