package leetcode;

import java.util.*;

public class PermutationSequence {

  int c = 0;
  String res = "";

  public String getPermutation(int n, int k) {

    var s = new TreeSet<Integer>();
    for (int i = 1; i <= n; i++) s.add(i);

    helper(s, k, "");

    return res;
  }

  void helper(Set<Integer> set, int k, String sb) {

    if (set.isEmpty()) {
      if (++c == k) res = sb;
    }

    for (int i : set) {
      var cs = new HashSet<>(set);
      cs.remove(i);
      helper(cs, k, sb + i);
    }
  }

  public static void main(String[] args) {
    var ps = new PermutationSequence();

    String permutation = ps.getPermutation(3, 3);
    System.out.println(permutation);
  }
}
