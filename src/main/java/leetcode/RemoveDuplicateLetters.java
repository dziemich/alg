package leetcode;

import java.util.*;

public class RemoveDuplicateLetters {

  public String removeDuplicateLetters(String s) {
    int a = (int) 'a';

    int[] letterCount = new int[26];
    boolean[] present = new boolean[26];

    for (char c : s.toCharArray()) {
      letterCount[c - 'a']++;
    }

    Stack<Integer> stack = new Stack<>();

    for (char c : s.toCharArray()) {
      int idx = c - 'a';
      letterCount[idx]--;

      if (present[idx]) continue;

      while (!stack.isEmpty() && stack.peek() > idx && letterCount[stack.peek()] > 0) {
        present[stack.pop()] = false;
      }

      stack.push(idx);
      present[idx] = true;
    }

    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) sb.insert(0, Character.valueOf((char) (stack.pop() + a)));

    return sb.toString();
  }

  public static void main(String[] args) {
    var rdl = new RemoveDuplicateLetters();

    System.out.println(rdl.removeDuplicateLetters("bcabc"));
  }
}
