package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
  public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
    int len = A.length;

    Map<Long, Integer> ab = new HashMap<>();


    // len ^ 2
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        ab.put((long) (A[i] + B[j]), ab.getOrDefault((long) (A[i] + B[j]), 0) + 1);
      }
    }


    int counter = 0;

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        int c = C[i];
        int d = D[j];
        var cd = ab.getOrDefault(-(c+d), 0);
        counter += cd;
      }
    }

    return counter;
  }

  public static void main(String[] args) {
    var fs2 = new FourSum2();

    var i = fs2.fourSumCount(new int[] {1, 2}, new int[] {-2, -1}, new int[] {-1, 2}, new int[] {0, 2});
    System.out.println("DONE: " + i);
  }
}
