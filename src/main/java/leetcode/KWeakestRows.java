package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class KWeakestRows {
  public int[] kWeakestRows(int[][] mat, int k) {

    List<int[]> l = new ArrayList<>();

    for (int i = 0; i < mat.length; i++) {
      int[] row = mat[i];
      int cnt = 0;
      for (int r : row) cnt += r;

      l.add(new int[] {i, cnt});
    }

    l.sort(Comparator.comparing(i -> i[1]));

    int[] res = new int[k];

    for (int i = 0; i < k; i++) {
      res[i] = l.get(i)[0];
    }
    return res;
  }
}
