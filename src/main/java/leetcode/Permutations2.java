package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
  Set<List<Integer>> set = new HashSet<>();

  public List<List<Integer>> permuteUnique(int[] nums) {
    set = new HashSet<>();
    helper(nums, new ArrayList<>(), new ArrayList<>());
    return new ArrayList<>(set);
  }

  private void helper(int[] nums, List<Integer> aux, List<Integer> indexAlreadyAdded) {
    if (aux.size() == nums.length) {
      set.add(aux);
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if(indexAlreadyAdded.contains(i)) continue;

      var copyAux = new ArrayList<>(aux);
      copyAux.add(nums[i]);
      var copyAdded = new ArrayList<>(indexAlreadyAdded);
      copyAdded.add(i);
      helper(nums, copyAux, copyAdded);
    }
  }

  public static void main(String[] args) {
    var p2 = new Permutations2();

    System.out.println(
    p2.permuteUnique(new int[] {1, 1, 2}).size());
  }
}
