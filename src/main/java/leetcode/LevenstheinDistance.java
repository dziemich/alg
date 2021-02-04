package leetcode;

public class LevenstheinDistance {
  public int minDistance(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[] dp = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      dp[i] = i;
    }

    for (int i = 1; i <= m; i++) {
      int[] curr = new int[n + 1];
      curr[0] = i;
      for (int j = 1; j <= n; j++) {
        int insert = dp[j] + 1;
        int delete = curr[j - 1] + 1;
        int replace = dp[j - 1];
        if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
          replace += 1;
        }
        curr[j] = Math.min(insert, Math.min(delete, replace));
      }
      dp = curr;
    }
    return dp[n];
  }

  public static void main(String[] args) {
    var ld = new LevenstheinDistance();

    System.out.println(ld.tymRazemSieUda("abcd", "acdx"));
  }

  public int editDistance(String s1, String s2) {

    int l1 = s1.length();
    int l2 = s2.length();

    int[] last = new int[l2 + 1];

    for (int i = 0; i <= l2; i++) {
      last[i] = i;
    }

    for (int i = 1; i <= l1; i++) {
      int[] current = new int[l2 + 1];
      current[0] = i;

      for (int j = 1; j <= l2; j++) {

        int insert = last[j] + 1;
        int delete = current[j - 1] + 1;
        int replace = last[j - 1];
        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
          replace += 1;
        }
        current[j] = Math.min(insert, Math.min(delete, replace));
      }
      last = current;
    }

    return last[l2];
  }

  public int tymRazemSieUda(String s1, String s2) {
    int l1 = s1.length();
    int l2 = s2.length();

    int[] last = new int[l2 + 1];

    for (int i = 0; i <= l2; i++) {
      last[i] = i;
    }

    for (int i = 1; i <= l1; i++) {
      int[] current = new int[l2 + 1];
      current[0] = i;

      for (int j = 1; j <= l2; j++) {

        int insert = last[j] + 1;
        int delete = current[j - 1] + 1;
        int remove = last[j - 1];

        if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
          remove += 1;
        }

        current[j] = Math.min(insert, Math.min(delete, remove));
      }
      last = current;
    }
    return last[l2];
  }
}
