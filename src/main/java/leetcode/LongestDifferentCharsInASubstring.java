package leetcode;

public class LongestDifferentCharsInASubstring {
  public int lengthOfLongestSubstring(String s) {

    if (s.length() == 0) return 0;

    StringBuilder helper = new StringBuilder();
    int longest = 1;
    int current = 0;

    for (int i = 0; i < s.length(); i++) {

      var letter = String.valueOf(s.charAt(i));

      if (helper.toString().contains(letter)) {
        helper = new StringBuilder(helper.substring(helper.indexOf(letter) + 1) + letter);
        current = helper.length();
      } else {
        helper.append(letter);
        current++;
      }
      longest = Math.max(longest, current);
    }

    return longest;
  }

  public static void main(String[] args) {
    var lds = new LongestDifferentCharsInASubstring();

    System.out.println(
    lds.lengthOfLongestSubstring("dvdf"));
  }
}
