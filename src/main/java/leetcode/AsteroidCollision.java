package leetcode;

import java.util.Stack;

public class AsteroidCollision {
  Stack<Integer> stack = new Stack<>();

  public int[] asteroidCollision(int[] asteroids) {
    if (asteroids.length == 0) return new int[] {};
    stack = new Stack<Integer>();
    stack.push(asteroids[0]);

    for (int i = 1; i < asteroids.length; i++) {
      var current = asteroids[i];
      handleCollision(current);
    }

    var ans = new int[stack.size()];

    for (int i = stack.size() - 1; i >= 0; i--) {
      ans[i] = stack.pop();
    }

    return ans;
  }

  void handleCollision(int current) {

    if (stack.isEmpty()) {
      stack.add(current);
      return;
    }

    int onTop = stack.peek();

    if (onTop * current > 0 || onTop < 0) {
      stack.push(current);
      return;
    }

    if (current * -1 == onTop) {
      stack.pop();
      return;
    }

    if (Math.abs(onTop) < Math.abs(current)) {
      stack.pop();
      handleCollision(current);
    }
  }

  public static void main(String[] args) {
    var ac = new AsteroidCollision();

    ac.asteroidCollision(new int[]{5,10,-5});
  }
}
