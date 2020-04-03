package crackingthecodeinterview.dp;

/*
Parens:
Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n pairs of parentheses.
EXAMPLE Input: 3 Output: « () ) ) J «) (», «» () J () ( (», () () ()
 */

import java.util.ArrayList;

public class Problem9 {
    private ArrayList<String> parens;

    public void solve(int n) {
        parens = new ArrayList<>();
        addPar(n, "(", 1, 0);

        parens.forEach(System.out::println);
    }

    private void addPar(int n, String acc, int lpCount, int rpCount) {
        if (acc.length() == 2 * n) {
            parens.add(acc);
            return;
        }

        if (lpCount < n){
            addPar(n, acc.concat("("), lpCount + 1, rpCount);
        }
        if (rpCount < lpCount)
        addPar(n, acc.concat(")"), lpCount, rpCount + 1);
    }

    public static void main(String[] args) {
        Problem9 p9 = new Problem9();

        p9.solve(3);
    }

}
