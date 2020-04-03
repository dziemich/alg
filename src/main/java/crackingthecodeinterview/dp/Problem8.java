package crackingthecodeinterview.dp;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem8 {
    private ArrayList<String> permutations;

    public void solve(String input){
        permutations = new ArrayList<>();
        HashMap<String, Integer> inputReduced = reduceInput(input);
        permutate(inputReduced, "", input.length());
        permutations.forEach(System.out::println);
    }

    private void permutate(HashMap<String, Integer> inputReduced, String currWord, int initialWordLength) {
        if (currWord.length() == initialWordLength){
            permutations.add(currWord);
            return;
        }
        for (var entry: new HashMap<>(inputReduced).entrySet()) {
            var letter = entry.getKey();
            if (entry.getValue() > 0) {
                var copy = new HashMap<>(inputReduced);
                copy.computeIfPresent(letter, (s, integer) -> integer - 1);
                permutate(copy, currWord.concat(letter), initialWordLength);
            }
        }
    }

    private HashMap<String, Integer> reduceInput(String input){
        var map = new HashMap<String, Integer>();

        for (var s: input.split("")){
            map.computeIfPresent(s, (s1, integer) -> integer + 1);
            map.putIfAbsent(s, 1);
        }

        return map;
    }

    public static void main(String[] args) {
        Problem8 p8 = new Problem8();

        p8.solve("aaaaaaaaaaaa");

        p8.solve("xyz");
        p8.solve("xxxyz");
    }

}
