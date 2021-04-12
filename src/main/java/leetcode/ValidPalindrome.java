package leetcode;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {

    int left = 0;
    int right = s.length() - 1;

    while (left < right) {

      char l = s.charAt(left);
      char r = s.charAt(right);

      if (!Character.isLetterOrDigit(l)) {
        left++;
        continue;
      }

      if (!Character.isLetterOrDigit(r)) {
        right--;
        continue;
      }

      System.out.println(l + "|" + r);

      if (Character.toLowerCase(l) != Character.toLowerCase(r)) return false;

      left++;
      right--;
    }

    return true;
  }

  public static void main(String[] args) {
    var vp = new ValidPalindrome();

    boolean res = vp.isPalindrome("race a car");
    System.out.println(res);
  }
}
