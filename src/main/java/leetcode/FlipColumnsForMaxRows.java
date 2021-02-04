package leetcode;

import java.util.HashMap;

public class FlipColumnsForMaxRows {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int[] ints : matrix) {
            StringBuilder builder = new StringBuilder();
            StringBuilder inverted = new StringBuilder();

            for (int r : ints) {
                builder.append(r);
                inverted.append(invert(r));
            }

            String normal = builder.toString();
            String inv = inverted.toString();

            map.computeIfPresent(normal, (s, integer) -> integer + 1);
            map.computeIfPresent(inv, (s, integer) -> integer + 1);
            map.computeIfAbsent(normal, n -> 0);
            map.computeIfAbsent(inv, n -> 0);
        }

        return map.values().stream().max(Integer::compareTo).get();
    }

    private int invert(int i){
        return (i + 1) % 2;
    }
}
