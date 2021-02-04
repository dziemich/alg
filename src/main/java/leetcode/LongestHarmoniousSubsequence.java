package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
  public int findLHS(int[] nums) {

    HashMap<String, Integer> map = new HashMap<>();
    HashMap<String, boolean[]> valid = new HashMap<>();

    for (int num : nums) {
      var keyPlus = (num - 1) + "-" + num;
      var keyMinus = num + "-" + (num + 1);

      var iPlus = map.getOrDefault(keyPlus, 0);
      var iMinus = map.getOrDefault(keyMinus, 0);

      var iPlusBool = valid.getOrDefault(keyPlus, new boolean[2]);
      var iMinusBool = valid.getOrDefault(keyMinus, new boolean[2]);

      iPlusBool[0] = true;
      iMinusBool[1] = true;

      valid.put(keyPlus, iPlusBool);
      valid.put(keyMinus, iMinusBool);

      map.put(keyPlus, iPlus + 1);
      map.put(keyMinus, iMinus + 1);
    }

    return map.entrySet().stream()
        .filter(
            e -> {
              boolean[] b = valid.get(e.getKey());
              return b[0] && b[1];
            })
        .map(Map.Entry::getValue)
        .max(Integer::compareTo)
        .orElse(0);
  }

  public static void main(String[] args) {
    var lhs = new LongestHarmoniousSubsequence();

    int lhs1 = lhs.findLHS(new int[] {1, 3, 2, 2, 5, 2, 3, 7});
    int lhs2 = lhs.findLHS(new int[] {1,1,1,1});
    System.out.println(lhs1);
    System.out.println(lhs2);
  }
}
