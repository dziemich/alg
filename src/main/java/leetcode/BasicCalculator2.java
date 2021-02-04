package leetcode;

import java.util.Stack;

public class BasicCalculator2 {
  public int calculate(String s) {
    Stack<Character> ops = new Stack<>();
    Stack<Integer> nums = new Stack<>();

    int num = 0;

    char[] cleanedInput = s.replaceAll("\\s", "").toCharArray();
    for (char c : cleanedInput) {
      if (Character.isDigit(c)) {
        num *= 10;
        num += c - '0';
      } else {
        if (ops.isEmpty()) {
          nums.push(num);
          ops.push(c);
          num = 0;
        } else {
          char topOp = ops.peek();
          if (topOp == '*') {
            ops.pop();
            int first = nums.pop();
            nums.push(first * num);
          } else if (topOp == '/') {
            ops.pop();
            int first = nums.pop();
            nums.push(first / num);
          } else {
            nums.push(num);
          }
          ops.push(c);
          num = 0;
        }
      }
    }

    nums.push(num);

    while (!ops.isEmpty()) {
      int second = nums.pop();
      int first = nums.pop();
      char op = ops.pop();

      if (op == '*') {
        nums.push(first * second);
      } else if (op == '/') {
        nums.push(first / second);
      } else if (op == '+') {
        if (!ops.isEmpty()) {
          char secOp = ops.pop();
          if (secOp == '+') {
            ops.push('+');
            nums.push(first + second);
          } else {
            int i = second - first;
            if (i < 0) {
              ops.push('-');
            } else {
              ops.push('+');
            }
            nums.push(Math.abs(i));
          }
        } else {
          nums.push(first + second);
        }
      } else {
        if (!ops.isEmpty()) {

          char secOp = ops.pop();
          if (secOp == '-') {
            ops.push('-');
            nums.push(first + second);
          } else {
            int i = first - second;
            if (i < 0) {
              ops.push('-');
            } else {
              ops.push('+');
            }
            nums.push(Math.abs(i));
          }

        } else {
          nums.push(first - second);
        }
      }
    }

    return nums.pop();
  }

  public static void main(String[] args) {
    var bc2 = new BasicCalculator2();
    System.out.println(bc2.calculate("1-1+1"));
  }
}
