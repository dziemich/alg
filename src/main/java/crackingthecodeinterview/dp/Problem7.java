package crackingthecodeinterview.dp;

import java.sql.Struct;
import java.util.ArrayList;

public class Problem7 {
    ArrayList<String> permutations = new ArrayList<>();
    ArrayList<String> permutations2 = new ArrayList<>();

    public void solve1(String input) {
        permutations.add("");

        String letter = String.valueOf(input.charAt(input.length() - 1));
        input = input.substring(0, input.length() - 1);
        permutate(input, letter);
        permutations.forEach(System.out::println);
    }

    private void permutate(String input, String letter) {
        if (input.length() == 0) {
            permutations.add(letter);
            return;
        }

        String last = String.valueOf(input.charAt(input.length() - 1));
        input = input.substring(0, input.length() - 1);

        permutate(input, last);

        for (var s : new ArrayList<>(permutations)) {
            permutations.add(s.concat(letter));
        }
    }

    private static String removeCharAt (String word, int index){
        return word.substring(0, index) + word.substring(index+1);
    }

    private void perm(String input, String currWord, int initialWordLength) {

        if (currWord.length() == initialWordLength){
            permutations2.add(currWord);
            return;
        }

        for (int i = 0; i < input.length(); i++){
            String removed = removeCharAt(input, i);
            String l = String.valueOf(input.charAt(i));
            perm(removed, currWord.concat(l), initialWordLength);
        }

    }

    public void solve2(String input){
        perm(input, "", input.length());
        permutations2.forEach(System.out::println);
    }

    public static void main(String[] args) {
        Problem7 p7 = new Problem7();
        p7.solve2("abc");
    }


}
