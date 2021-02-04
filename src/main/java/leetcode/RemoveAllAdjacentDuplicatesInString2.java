package leetcode;

import java.util.*;

public class RemoveAllAdjacentDuplicatesInString2 {
  public String removeDuplicates(String s, int k) {

    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder(s);

    int i = 0;

    while (i < sb.length()) {

      if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
        stack.push(1);
      } else {
        int count = stack.pop() + 1;
        if (count == k) {
          sb.delete(i - k + 1, i + 1);
          i = i - k;
        } else {
          stack.push(count);
        }
      }
      i++;
    }

    return sb.toString();
  }
}
