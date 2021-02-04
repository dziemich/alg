package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicateInFileSystem {
  public List<List<String>> findDuplicate(String[] paths) {
    Map<String, List<String>> map = new HashMap<>();

    for (var p : paths) {
      var s = p.split("(");
      var filepath = s[0];
      var filecontent = s[1].substring(1, s[1].length() - 1);
      map.computeIfPresent(
          filecontent,
          (s1, strings) ->
              Stream.concat(Stream.of(filepath), strings.stream()).collect(Collectors.toList()));
      map.computeIfAbsent(filepath, s1 -> List.of(filepath));
    }

    return new ArrayList<>(map.values());
  }
}
