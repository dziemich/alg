package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/generate-parentheses/
 */

public class GenerateParentheses {
    ArrayList<String> ret = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        helper(n, n, "");
        return ret;
    }
    
    private void helper(int left, int right, String acc){
        if (left == 0 && right == 0) {
            ret.add(acc);
            return;
        }
        if (left == right) {
            helper(left - 1, right, acc + "(");    
        }
        else {
            if (left > 0) {
                helper(left - 1, right, acc + "(");
            }
            helper(left, right -1, acc + ")");
        }
    }
    
}
