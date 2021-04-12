package leetcode;

import java.util.HashMap;

public class CountNicePairs {
  public int countNicePairs(int[] nums) {
    int counter = 0;
    HashMap<Integer, Integer> occ = new HashMap<>();
    int MOD = 1_000_000_007;
    for (int n : nums) {
      int rev = rev(n);
      int diff = n - rev;
      int h = occ.getOrDefault(diff, 0);
      counter += h;
      occ.put(diff, h + 1);
      counter = counter % MOD;
    }

    return counter;
  }

  int rev(int i) {
    int acc = 0;
    while (i > 0) {
      acc *= 10;
      acc += i % 10;
      i /= 10;
    }
    return acc;
  }

  public static void main(String[] args) {
    int[] arr = new int[] {13, 10, 35, 24, 76};
    var cnp = new CountNicePairs();

    cnp.countNicePairs(arr);
  }
}
