package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class ReduceArraySizeToHalf {

  public int minSetSize(int[] arr) {

    Map<Integer, Integer> counts = new HashMap<>();

    for (int i : arr) {
      counts.put(i, counts.getOrDefault(i, 0) + 1);
    }

    var sorted =
        counts.values().stream()
            .sorted((a, b) -> Integer.compare(b, a))
            .collect(Collectors.toList());

    int acc = 0;
    int len = arr.length / 2;
    int idx = 0;

    while (acc < len) {
      acc += sorted.get(idx++);
    }

    return idx;
  }

  public static void main(String[] args) {
    var rasth = new ReduceArraySizeToHalf();
    int i = rasth.minSetSize(new int[] {3, 3, 3, 3, 5, 5, 5, 2, 2, 7});
  }
}
