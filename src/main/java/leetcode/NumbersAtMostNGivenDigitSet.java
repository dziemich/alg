package leetcode;

public class NumbersAtMostNGivenDigitSet {

  public int atMostNGivenDigitSet(String[] digits, int n) {
    int valid = 0;
    int i = 1;
    while (Math.pow(10, i) <= n) {
      valid += Math.pow(digits.length, i);
      i++;
    }

    int[] ints = new int[digits.length];

    for (int j = 0; j < digits.length; j++) {
      ints[j] = Integer.parseInt(digits[j]);
    }

    int[] dp = new int[i+2];
    dp[i+1] = 1;

    String ns = String.valueOf(n);



    for (int j = i; j >= 0; j--) {
      int c = Character.getNumericValue(ns.charAt(j));
      for (int in : ints) {
        if (in < c) {
          dp[j] += Math.pow(digits.length, i - j);
        } else if (in == c) {
          dp[j] *= dp[j + 1];
        }
      }
    }

    return valid + dp[0];
  }

  public static void main(String[] args) {

    var nam = new NumbersAtMostNGivenDigitSet();

    System.out.println(nam.atMostNGivenDigitSet(new String[] {"1", "3", "5", "7"}, 100));
  }
}
