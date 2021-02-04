package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class MinimumDeletionsToMakeStringBalanced {
  int min = Integer.MAX_VALUE;

  public int minimumDeletions3(String s) {
    min = Integer.MAX_VALUE;
    helper(s, "", 1, 1);
    helper(s, s.substring(0, 1), 0, 1);
    return min;
  }

  void helper(String s, String curr, int delNums, int level) {
    if (level == s.length()) {
      if (isValid(curr)) {
        min = Math.min(delNums, min);
      }
      return;
    }
    char c = s.charAt(level);

    helper(s, curr, delNums + 1, level + 1);
    if (isValid(curr + c)) helper(s, curr + c, delNums, level + 1);
  }

  boolean isValid(String s) {
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) == 'b' && s.charAt(i) == 'a') return false;
    }
    return true;
  }

  public int minimumDeletions2(String s) {

    var list = new ArrayList<int[]>();

    int currCount = 1;
    char onTop = s.charAt(0);

    for (int i = 1; i < s.length(); i++) {
      if (onTop == s.charAt(i)) currCount++;
      else {
        list.add(new int[] {(int) onTop, currCount});
        currCount = 1;
        onTop = s.charAt(i);
      }
    }
    list.add(new int[] {(int) onTop, currCount});

    int min = 0;
    int[] presentInFinal = new int[2];

    for(int i =0 ; i < list.size(); i++){
      int[] ints = list.get(i);

      int[] count = new int[2];

      for(int j = i + 1; j < list.size(); j++){
        int[] ints1 = list.get(j);
        count[ints1[0] - 'a'] += ints1[1];
      }

      int which = ints[0] - 'a';
      if(count[which] + ints[1] + presentInFinal[which] < count[(which + 1) % 2]){
        min += ints[1];
      } else {
        presentInFinal[which] += ints[1];
      }
    }

    return min;

  }

  public int minimumDeletions(String s){

    Stack<Character> stack = new Stack<>();

    int n = s.length();
    int res = 0;

    for(int i = n - 1; i >= 0; i--){
      char c = s.charAt(i);

      if(!stack.isEmpty() && stack.peek() < c){
        res++;
        stack.pop();
      } else {
        stack.push(c);
      }
    }

    return res;
  }

  public static void main(String[] args) {
    //
    var mind = new MinimumDeletionsToMakeStringBalanced();
    System.out.println(mind.minimumDeletions("aababbaaaaaab"));
  }
}
