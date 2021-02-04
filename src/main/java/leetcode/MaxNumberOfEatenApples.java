package leetcode;

import java.util.TreeMap;

public class MaxNumberOfEatenApples {
  public int eatenApples(int[] apples, int[] days) {
    int count = 0;
    int day = 0;

    TreeMap<Integer, Integer> expiry = new TreeMap<>(Integer::compare);

    for (; day < apples.length; day++) {
      if (apples[day] > 0) {
        int val = day + days[day];
        expiry.put(val, expiry.getOrDefault(val, 0) + apples[day]);
      }

      while (!expiry.isEmpty()) {
        var first = expiry.pollFirstEntry();
        if (day < first.getKey()) {
          if (first.getValue() > 1) {
            expiry.put(first.getKey(), first.getValue() - 1);
          }
          count++;
          break;
        }
      }
    }

    while (!expiry.isEmpty()) {
      var first = expiry.pollFirstEntry();
      if (day < first.getKey()) {
        if (first.getValue() > 1) {
          expiry.put(first.getKey(), first.getValue() - 1);
        }
        count++;
      }
      day++;
    }
    return count;
  }

  public static void main(String[] args) {
    var maoea = new MaxNumberOfEatenApples();

    int i = maoea.eatenApples(
            new int[]{
                    1, 10, 17, 10, 12, 6, 20, 8, 8, 22, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 1, 2, 3, 5, 2, 1, 0, 0, 0, 0, 0, 0, 23
            },
            new int[]{
                    19999, 11, 18, 22, 5, 2, 14, 5, 20, 7, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 3, 2, 1, 4, 2, 7, 0, 0, 0, 0, 0, 0, 1
            });
//    int i = maoea.eatenApples(
//            new int[]{
//                    1,2,3,5,2
//            },
//            new int[]{
//                    3,2,1,4,2
//            });

    System.out.println("done: " + i);
  }
}
