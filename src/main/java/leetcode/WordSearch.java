package leetcode;

public class WordSearch {
  public boolean exist(char[][] board, String word) {
    if (word.isEmpty()) return true;
    char[] cha = word.toCharArray();
    boolean b = false;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dfs(board, cha, i, j, 0, new boolean[board.length][board[0].length])) return true;
      }
    }
    return b;
  }

  boolean dfs(char[][] board, char[] cha, int i, int j, int idx, boolean[][] visited) {
    // out of range
    if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
    if (cha.length == idx) return true;
    if (board[i][j] != cha[idx]) return false;

    return dfs(board, cha, i - 1, j, idx + 1, visited)
        || dfs(board, cha, i, j - 1, idx + 1, visited)
        || dfs(board, cha, i + 1, j, idx + 1, visited)
        || dfs(board, cha, i, j + 1, idx + 1, visited);
  }

  public static void main(String[] args) {
    var input =
        new char[][] {
          new char[] {'A', 'B', 'C', 'E'},
          new char[] {'S', 'F', 'C', 'S'},
          new char[] {'A', 'D', 'E', 'E'},
        };
    var ws = new WordSearch();

    System.out.println(ws.exist(input, "ABCCED"));
  }
}
