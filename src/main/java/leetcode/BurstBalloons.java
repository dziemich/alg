package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BurstBalloons {
  public int maxCoins(int[] nums) {

    var balloons = Arrays.stream(nums).boxed().collect(Collectors.toCollection(ArrayList::new));
    int coins = 0;

    while (balloons.size() > 0) {

      int size = balloons.size();

      int minIndex = 0;
      int min = balloons.get(minIndex);

      for (int i = 0; i < size; i++) {
        if (min > balloons.get(i)) {
          minIndex = i;
          min = balloons.get(i);
        }
      }

      int amount =
          balloons.get(minIndex)
              * (minIndex > 0 ? balloons.get(minIndex - 1) : 1)
              * (minIndex < size - 1 ? balloons.get(minIndex + 1) : 1);

      balloons.remove(minIndex);

      coins += amount;
    }
    return coins;
  }

  public static void main(String[] args) {
    var bb = new BurstBalloons();

    bb.maxCoins(new int[]{3,1,5,8});
  }
}
