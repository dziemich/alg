package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/
 */

public class CombinationSum {
    List<List<Integer>> ret = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        helper(candidates, target, new ArrayList<>());
        return ret;
    }

    private void helper(int[] candidates, int targetSum, List<Integer> currSum) {

        int sum = currSum.stream().reduce(Integer::sum).orElse(0);

        if (sum == targetSum) {
            var alreadyPresent = ret.stream().anyMatch(l -> twoListsAreSame(l, currSum));
            if (!alreadyPresent) ret.add(currSum);
        }

        for (int c : candidates) {
            var clone = new ArrayList<>(currSum);
            if (sum + c <= targetSum) {
                clone.add(c);
                helper(candidates, targetSum, clone);
            }
        }
    }
    
    static boolean twoListsAreSame(List<Integer> l1, List<Integer> l2){
        if (l1.size() != l2.size()) return false;
        
        var l1Copy = new ArrayList<>(l1);
        var l2Copy = new ArrayList<>(l2);

        Collections.sort(l1Copy);
        Collections.sort(l2Copy);
        
        for (int i = 0; i < l1.size(); i++) {
            if (!l1Copy.get(i).equals(l2Copy.get(i))) return false;
        }
        return true;
    }
}
