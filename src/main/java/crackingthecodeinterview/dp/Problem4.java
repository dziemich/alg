package crackingthecodeinterview.dp;

/*
Power Set:
Write a method to return all subsets of a set.
 */

import java.util.ArrayList;
import java.util.HashSet;

public class Problem4 {
    private ArrayList<HashSet<Integer>> list = new ArrayList<>();

    public ArrayList<HashSet<Integer>> solve(ArrayList<Integer> input) {
        list.add(new HashSet<>());
        var lastEl = input.remove(input.size() - 1);
        permutate(lastEl, input);
        return list;
    }

    private void permutate(Integer el, ArrayList<Integer> input) {
        if (input.size() == 0) {
            HashSet<Integer> set = new HashSet<>();
            set.add(el);
            list.add(set);
            return;
        }
        var lastEl = input.remove(input.size() - 1);
        permutate(lastEl, input);

        for (var l : new ArrayList<>(list)) {
            var newSubset = new HashSet<>(l);
            newSubset.add(el);
            list.add(newSubset);
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(5);
        input.add(6);
        input.add(7);
        Problem4 p4 = new Problem4();
        ArrayList<HashSet<Integer>> subsets = p4.solve(input);
        subsets.forEach(set -> {
                    System.out.print("<");
                    for (var i : set) System.out.print(" " + i);
                    System.out.println(" >");
                }
        );
    }
}
