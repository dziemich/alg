package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
https://leetcode.com/problems/letter-case-permutation/
 */

public class LetterCasePermutation {
    private List<String> permutations = new ArrayList<>();

    public List<String> letterCasePermutation(String S) {

        permutations = new ArrayList<>();

        if(S.isEmpty()) return Collections.emptyList();

        helper(S, 0, "");
        return permutations;

    }

    void helper(String s, int level, String current){
        if(level == s.length()){
            permutations.add(current);
        } else {
            var c = s.charAt(level);
            if(isLetter(c)){
                helper(s, level + 1, current + Character.toString(c).toUpperCase());
                helper(s, level + 1, current + Character.toString(c).toLowerCase());
            } else {
                helper(s, level + 1, current + c);
            }
        }
    }

    boolean isLetter(char l){
        return l>='a' && l<='z';
    }

}
