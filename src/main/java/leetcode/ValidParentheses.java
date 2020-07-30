package leetcode;

import java.util.Stack;
/*
https://leetcode.com/problems/valid-parentheses/
*/
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                var onTop = stack.peek();
                var current = s.charAt(i);
                if (
                        (onTop.equals('(') && current == ')') ||
                                (onTop.equals('[') && current == ']') ||
                                (onTop.equals('{') && current == '}')
                ) {
                    stack.pop();
                } else {
                    stack.push(current);
                }
            }
        }
        return stack.isEmpty();
    }
}
