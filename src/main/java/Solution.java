import java.util.HashMap;

public class Solution {

  // Complete the matchingStrings function below.
  static int[] matchingStrings(String[] strings, String[] queries) {
    HashMap<String, Integer> map = new HashMap();
    for (String s : strings) {
      map.computeIfPresent(s, (k, v) -> v + 1);
      map.computeIfAbsent("key5", v -> 1);
    }
    int[] arr = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      arr[i] = map.get(queries[i]);
    }

    return arr;
  }
  }
