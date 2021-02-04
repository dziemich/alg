package leetcode;

import java.util.Stack;

public class MinimumRemToMakeValidParenthesis {
  public String minRemoveToMakeValid(String s) {

    Stack<Integer> lpar = new Stack<>();
    Stack<Integer> rpar = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == '(') {
        lpar.push(i);
      }

      if (c == ')') {
        if (lpar.isEmpty()) {
          rpar.push(i);
        } else {
          lpar.pop();
        }
      }
    }

    String output = s;

    while (!lpar.isEmpty() || !rpar.isEmpty()) {
      int idx = -1;
      if (lpar.isEmpty()) {
        idx = rpar.pop();
      } else if (rpar.isEmpty()) {
        idx = rpar.pop();
      } else {
        int l = lpar.peek();
        int r = rpar.peek();

        if (l > r) {
          lpar.pop();
          idx = l;
        } else {
          rpar.pop();
          idx = r;
        }
      }

      output = output.substring(0, idx) + output.substring(idx + 1);
    }
    return output;
  }

  public static void main(String[] args) {
    var min = new MinimumRemToMakeValidParenthesis();

    min.minRemoveToMakeValid("lee(t(c)o)de)");
  }
}
