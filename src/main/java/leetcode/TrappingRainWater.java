package leetcode;

public class TrappingRainWater {
  public int trap(int[] height) {
    int left = 0, right = height.length - 1, max = 0, temp = 0;
    while (left < right) {
      if (height[left] <= height[right]) {
        temp = Math.max(temp, height[left]);
        max += temp - height[left++];
      } else {
        temp = Math.max(temp, height[right]);
        max += temp - height[right--];
      }
    }

    return max;
  }

  public static void main(String[] args) {
    var trw = new TrappingRainWater();

    System.out.println(trw.trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));


  }
}
