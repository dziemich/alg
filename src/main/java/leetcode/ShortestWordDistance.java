package leetcode;

public class ShortestWordDistance {
  public int shortestDistance(String[] words, String word1, String word2) {
    int idx1 = -1;
    int idx2 = -1;

    int distance = Integer.MAX_VALUE;

    for (int i = 0; i < words.length; i++) {
      String curr = words[i];
      if (curr.equals(word1)) {
        if (idx1 != -1 && idx2 != -1) {
          distance = Math.min(Math.abs(idx1 - idx2), distance);
        }
        idx1 = i;
      }
      if (curr.equals(word2)) {
        if (idx1 != -1 && idx2 != -1) {
          distance = Math.min(Math.abs(idx1 - idx2), distance);
        }
        idx2 = i;
      }
    }
    distance = Math.min(Math.abs(idx1 - idx2), distance);
    return distance;
  }

  public static void main(String[] args) {
    var swd = new ShortestWordDistance();

    swd.shortestDistance(
        new String[] {"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice");
  }
}
