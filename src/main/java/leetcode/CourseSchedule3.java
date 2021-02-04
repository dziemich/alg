package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CourseSchedule3 {
  int max = 0;

  public int scheduleCourse(int[][] courses) {

    // brute force: create all permutations, count how many are possible in each of these, find the
    // largest n!
    // order by deadline
    // order by length

    Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
    List<int[]> courseList = Arrays.asList(courses);
    helper(courseList, 0, 0);
    return max;
  }

  void helper(List<int[]> courses, int day, int taken) {
    for (int i = 0; i < courses.size(); i++) {
      var copy = new ArrayList<>(courses);
      var c = copy.get(i);
      if (c[1] >= day + c[0]) {
        copy.remove(i);
        helper(copy, day + c[0], taken + 1);
      }
    }
    max = Math.max(taken, max);
  }

  public static void main(String[] args) {
    var cs3 = new CourseSchedule3();

    cs3.scheduleCourse(
        new int[][] {
          new int[] {100, 200},
          new int[] {200, 1300},
          new int[] {1000, 1250},
          new int[] {2000, 3200}
        });
  }
}
