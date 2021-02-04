package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequentWords {
  public List<String> topKFrequent(String[] words, int k) {

    Map<String, Integer> map = new HashMap<>();

    for (String word : words) {
      map.putIfAbsent(word, 1);
      map.put(word, map.get(word) + 1);
    }

    return map.entrySet().stream()
        .sorted(
            (o1, o2) -> {
              int diff = Integer.compare(o2.getValue(), o1.getValue());
              if (diff == 0) return o2.getKey().compareTo(o1.getKey());
              return diff;
            })
        .limit(k)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }
}
