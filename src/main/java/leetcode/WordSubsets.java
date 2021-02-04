package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class WordSubsets {
  public List<String> wordSubsets(String[] A, String[] B) {

    var bJoined = new HashMap<Character, Integer>();

    for (String word : B) {
      var reduced = reduceWord(word);
      reduced.forEach((key, value) -> bJoined.merge(key, value, Math::max));
    }

    return Arrays.stream(A)
        .filter(
            s -> {
              Map<Character, Integer> reduced = reduceWord(s);

              return bJoined.entrySet().stream()
                  .allMatch(
                      bLetter -> reduced.getOrDefault(bLetter.getKey(), 0) >= bLetter.getValue());
            })
        .collect(Collectors.toUnmodifiableList());
  }

  private Map<Character, Integer> reduceWord(String word) {
    HashMap<Character, Integer> letters = new HashMap<>();
    for (var letter : word.toCharArray()) {
      letters.computeIfPresent(letter, (k, v) -> v + 1);
      letters.putIfAbsent(letter, 1);
    }

    return letters;
  }
}
