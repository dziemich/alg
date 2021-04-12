package leetcode;

import java.util.Set;

public class ReverseVowelsOfAString {
  public String reverseVowels(String s) {
    char[] arr = s.toCharArray();
    var vowels = Set.of('a', 'e', 'i', 'o', 'u');

    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      while (left < right && !vowels.contains(arr[left])) left++;
      while (left < right && !vowels.contains(arr[right])) right--;
      char tmp = arr[left];
      arr[left] = arr[right];
      arr[right] = tmp;
    }

    return new String(arr);
  }

  public static void main(String[] args) {
    var rvoas = new ReverseVowelsOfAString();

    rvoas.reverseVowels("hello");
  }
}
