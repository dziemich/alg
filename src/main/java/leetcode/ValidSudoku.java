package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/valid-sudoku/
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Set<Integer> s1 = new HashSet<>();
            for (int j = 0; j < board.length; j++) {

                if (board[i][j] != '.') {
                    int num = Integer.parseInt(Character.toString(board[i][j]));
                    if (s1.contains(num)) {
                        return false;
                    } else {
                        s1.add(num);
                    }
                }

            }
        }
        
        for (int i = 0; i < board.length; i++) {
            Set<Integer> s2 = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                

                if (board[j][i] != '.') {
                    int num = Integer.parseInt(Character.toString(board[j][i]));
                    if (s2.contains(num)) {
                        return false;
                    } else {
                        s2.add(num);
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {

                Set<Integer> s = new HashSet<>();

                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] != '.') {
                            int num = Integer.parseInt(Character.toString(board[i + k][j + l]));
                            if (s.contains(num)) {
                                return false;
                            } else {
                                s.add(num);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
