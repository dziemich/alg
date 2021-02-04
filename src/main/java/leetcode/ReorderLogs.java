package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ReorderLogs {
  public String[] reorderLogFiles(String[] logs) {
    List<String> letterLogs = new ArrayList<>();
    List<String> digitLogs = new ArrayList<>();

    for (String log : logs) {
      if (Character.isDigit(log.substring(log.indexOf(" ")).charAt(1))) {
        digitLogs.add(log);
      } else {
        letterLogs.add(log);
      }
    }


    letterLogs.sort(
        Comparator.comparing((String s) -> s.substring(s.indexOf(" ") + 1)).thenComparing(s -> s));

    return Stream.concat(letterLogs.stream(), digitLogs.stream()).toArray(String[]::new);
  }

  public static void main(String[] args) {
    var rl = new ReorderLogs();
    var res =
        rl.reorderLogFiles(
            new String[] {
              "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
            });
    System.out.println("DONE");
  }
}
