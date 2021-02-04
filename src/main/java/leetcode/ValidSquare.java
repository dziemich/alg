package leetcode;

import java.util.Arrays;

public class ValidSquare {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    return helper(p1, p2, p3, p4) && helper(p2, p3, p4, p1);
  }

  private boolean helper(int[] p1, int[] p2, int[] p3, int[] p4) {
    var p1p2 = Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
    var p1p3 = Math.sqrt(Math.pow(p3[0] - p1[0], 2) + Math.pow(p3[1] - p1[1], 2));
    var p2p3 = Math.sqrt(Math.pow(p3[0] - p2[0], 2) + Math.pow(p3[1] - p2[1], 2));
    var p1p4 = Math.sqrt(Math.pow(p4[0] - p1[0], 2) + Math.pow(p4[1] - p1[1], 2));

    if (Arrays.stream(new double[] {p1p2, p1p3, p1p4}).anyMatch(dist -> dist == 0.0d)) {
      return false;
    }

    if (p1p2 == p1p3) {
      return Math.round(Math.sqrt(2) * p1p2 * 1000) / 1000 == Math.round(p1p4 * 1000) / 1000;
    }

    if (p1p2 > p1p3 && p2p3 == p1p3) {
      return p1p4 == p1p3;
    }

    if (p1p3 > p1p2 && p2p3 == p1p2) {
      return p1p4 == p1p2;
    }
    return false;
  }

  public static void main(String[] args) {
    var vs = new ValidSquare();

    //    System.out.println(
    //        vs.validSquare(new int[] {0, 1}, new int[] {1, 2}, new int[] {0, 2}, new int[] {0,
    // 0}));
    System.out.println(
        vs.validSquare(new int[] {1, 0}, new int[] {-1, 0}, new int[] {0, 1}, new int[] {0, -1}));
  }
}
