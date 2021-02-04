package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestoreIpAddresses {

  List<String> results = new ArrayList<>();

  public List<String> restoreIpAddresses(String s) {
    if (s.length() > 12) return Collections.emptyList();

    results = new ArrayList<>();
    helper(s, "", 0);
    return results;
  }

  private void helper(String s, String current, int segments) {

    if (segments == 4 || s.isEmpty()) {
      if (s.isEmpty() && segments == 4) {
        results.add(current.substring(0, current.lastIndexOf('.')));
      }
      return;
    }

    if (s.charAt(0) == '0') {
      helper(s.substring(1), current + "0.", segments + 1);
    } else {
      for (int i = 1; i <= Math.min(3, s.length()); i++) {
        if (Integer.parseInt(s.substring(0, i)) < 256) {
          helper(s.substring(i), current + s.substring(0, i) + ".", segments + 1);
        }
      }
    }
  }

  public static void main(String[] args) {
    var ripa = new RestoreIpAddresses();

    List<String> strings = ripa.restoreIpAddresses("10001");

    System.out.println("D " + strings.size());
  }
}
