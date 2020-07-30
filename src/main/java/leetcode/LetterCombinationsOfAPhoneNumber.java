package leetcode;

import java.util.*;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class LetterCombinationsOfAPhoneNumber {

    private ArrayList<String> ret = new ArrayList<>();
    private HashMap<Integer, String> mapping = new HashMap<>(
            Map.of(
                    2, "abc",
                    3, "def",
                    4, "ghi",
                    5, "jkl",
                    6, "mno",
                    7, "pqrs",
                    8, "tuv",
                    9, "wxyz"
            )
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        helper(digits, 0, "");
        return ret;
    }

    private void helper(String digits, int level, String acc) {
        if (level == digits.length()) {
            ret.add(acc);
        } else {
            var letters = mapping.get(Integer.parseInt(Character.toString(digits.charAt(level))));
            for (int i = 0; i < letters.length(); i++) {
                var l = Character.toString(letters.charAt(i));
                helper(digits, level + 1, acc + l);
            }
        }
    }
}
