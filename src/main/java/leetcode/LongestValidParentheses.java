package leetcode;

import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {

        int max = 0;
        int counter = 0;
        int overhead = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){

            var c = s.charAt(i);

            if(c == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()){
                    max = Math.max(overhead, max);
                    overhead = 0;
                } else {
                    var popped = stack.pop();
                    counter = i - popped + 1;
                    overhead += counter;
                    max = Math.max(counter, max);
                }
            }
        }
        if(!stack.isEmpty()){
            max = Math.max(max, s.length() - stack.lastElement() - 1);
        }
        return Math.max(overhead, max);
    }

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

  public static void main(String[] args) {
    var lvp = new LongestValidParentheses();
    lvp.longestValidParentheses2("))(())");
  }
}
