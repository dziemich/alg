package leetcode;

import java.util.Stack;

public class DecodeStrings {
  public String decodeString1(String s) {

    Stack<Integer> multipliers = new Stack<>();
    Stack<String> strings = new Stack<>();

    StringBuilder result = new StringBuilder();

    int parenOpened = 0;

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (Character.isLetter(c)) {
        if (multipliers.isEmpty()) {
          result.append(c);
        } else {
          if (s.charAt(i - 1) == '[') {
            strings.push(String.valueOf(c));
          } else {
            String popped = strings.pop();
            strings.push(popped + c);
          }
        }
      } else if (Character.isDigit(c)) {
        char current = c;
        int num = 0;

        while (Character.isDigit(current)) {
          num *= 10;
          num += current - '0';
          current = s.charAt(++i);
        }
        parenOpened++;
        multipliers.push(num);
      } else if (c == ']') {
        parenOpened--;
        String popped = strings.pop();
        Integer mul = multipliers.pop();

        StringBuilder builder = new StringBuilder();

        builder.append(String.valueOf(popped).repeat(Math.max(0, mul)));

        if (multipliers.isEmpty()) {
          result.append(builder.toString());

        } else {
          if (strings.isEmpty()) {
            strings.push(builder.toString());
          } else {
            String popped2 = strings.pop();
            strings.push(popped2 + builder.toString());
          }
        }
      }
    }
    return result.toString();
  }

  public String decodeString(String s) {

    Stack<Integer> multipliers = new Stack<>();
    Stack<String> strings = new Stack<>();
    StringBuilder currentString = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {

      char c = s.charAt(i);

      if (Character.isDigit(c)) {
        char current = c;
        int num = 0;
        while (Character.isDigit(current)) {
          num *= 10;
          num += current - '0';
          current = s.charAt(++i);
        }
        multipliers.push(num);
        strings.push(currentString.toString());
        currentString = new StringBuilder();
      } else if (Character.isLetter(c)) {
        currentString.append(c);
      } else {
        int mul = multipliers.pop();
        String popped = strings.pop();
        currentString = new StringBuilder(popped + String.valueOf(currentString).repeat(Math.max(0, mul)));
      }
    }
    return currentString.toString();
  }

  public static void main(String[] args) {
    var ds = new DecodeStrings();
    System.out.println(ds.decodeString("3[a]2[bc]"));
  }
}
