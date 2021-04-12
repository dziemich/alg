package leetcode;

import java.util.*;

public class MakeTheStringGreat {
  public String makeGood(String s) {

    Stack<Character> stack = new Stack<>();

    for (char c : s.toCharArray()) {

      if (!stack.isEmpty()
          && ((Character.isUpperCase(c) && Character.toLowerCase(c) == stack.peek())
              || (Character.isLowerCase(c) && Character.toUpperCase(c) == stack.peek()))) {
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
    }

    return sb.toString();
  }
}
