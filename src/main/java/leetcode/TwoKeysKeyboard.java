package leetcode;

public class TwoKeysKeyboard {
  /*

  10 -> 5 -> Copy -> Paste

  8 ->

  1 -> 0
  2 -> C,P -> 2
  3 -> C,P,P -> 3
  4 -> C,P,C,P / C,P,P,P -> 4
  5 -> C,P,P,P,P -> 5
  6 -> C,P,P,C,P -> 5
  8 -> C,P,C,P,C,P -> 6
  9 -> C,P,P,C,P,P -> 6
  25 -> C,P,P,P,P,C,P,P,P,P ->
  */

  int[] memo = new int[1000];

  public int minSteps(int n) {
    if (memo[n] != 0) return memo[n];
    for (int i = 2; i < n / 2; i++) {
      if (n % i == 0) {
        int res = minSteps(n / i) + i;
        memo[n] = res;
        return res;
      }
    }
    memo[n] = n;
    return n;
  }

  public static void main(String[] args) {
    //
    var tkk = new TwoKeysKeyboard();

    // memo[36] -> memo[18] -> memo[9] -> memo[3];
    int i = tkk.minSteps(36);

    System.out.println("DONE " + i);
  }
}
