package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/lexicographical-order/
 */

public class LexicographicalOrder {
    public List<Integer> lexicalOrder(int n) {
        var l = new ArrayList<Integer>();
        for (int i = 1; i<= n; i++){
            l.add(i);
        }
        l.sort(this::firstIsLower);
        return l;
    }

    private int firstIsLower(int first, int second) {
        String sf = String.valueOf(first);
        String ss = String.valueOf(second);

        var shorter = Math.min(sf.length(), ss.length());

        for (int i = 0; i < shorter; i++) {
            int f = Integer.parseInt(sf.substring(i, i + 1));
            int s = Integer.parseInt(ss.substring(i, i + 1));
            if (s > f) return -1;
            else if (s < f) return 1;
        }
        return sf.length() > ss.length() ? 1 : -1;
    }
}
