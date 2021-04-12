package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LargestNumber {
  public String largestNumber(int[] nums) {
    String res = Arrays.stream(nums)
        .mapToObj(i -> ((Integer) i).toString())
        .sorted(this::customSort)
        .collect(Collectors.joining(""));

    return res.startsWith("0") ? "0" : res;
  }

  private int customSort(String str1, String str2) {
    String s1 = str1 + str2;
    String s2 = str2 + str1;
    return s2.compareTo(s1);
  }

  public static void main(String[] args) {
    var ln = new LargestNumber();
    System.out.println(ln.largestNumber(new int[] {3, 30, 34, 5, 9}));
  }
}
