package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class CustomSortString791 {

  public String customSortString(String S, String T) {
    var builder = new StringBuilder();

    for (int i = 0; i < S.length(); i++) {
      char c = S.charAt(i);

      if (!T.contains(Character.toString(c))) continue;

      var times = T.chars().filter(s -> s == c).count();

      for (int t = 0; t < times; t++) {
        builder.append(c);
      }
    }

    String missing =
        T.chars().mapToObj(c -> Character.toString((char) c)).collect(Collectors.joining(""));
    builder.append(missing);
    return builder.toString();
  }
}
