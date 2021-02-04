package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeDifference {

  public int findMinDifference(List<String> timePoints) {

    timePoints.sort(
        (t1, t2) -> {
          String[] hoursAndMins1 = t1.split(":");
          String[] hoursAndMins2 = t2.split(":");

          int hourDiff =
              Integer.compare(
                  Integer.parseInt(hoursAndMins1[0]), Integer.parseInt(hoursAndMins2[0]));

          return hourDiff == 0
              ? Integer.compare(
                  Integer.parseInt(hoursAndMins1[1]), Integer.parseInt(hoursAndMins2[1]))
              : hourDiff;
        });

    String previous = timePoints.get(0);

    int min = computeWrapMinDiff(previous, timePoints.get(timePoints.size() - 1));

    for (int i = 1; i < timePoints.size(); i++) {
      String current = timePoints.get(i);
      min = Math.min(min, computeMinDiff(previous, current));
      previous = current;
    }

    return min;
  }

  private int computeMinDiff(String earlier, String later) {
    String[] earlyHoursAndMins = earlier.split(":");
    String[] laterHoursAndMins = later.split(":");

    int hours = Integer.parseInt(laterHoursAndMins[0]) - Integer.parseInt(earlyHoursAndMins[0]);
    int minutes = Integer.parseInt(laterHoursAndMins[1]) - Integer.parseInt(earlyHoursAndMins[1]);

    return hours * 60 + minutes;
  }

  private int computeWrapMinDiff(String earlier, String later) {
    String[] earlyHoursAndMins = earlier.split(":");
    String[] laterHoursAndMins = later.split(":");

    int laterHours = 24 - Integer.parseInt(laterHoursAndMins[0]);
    int laterMinutes = Integer.parseInt(laterHoursAndMins[1]) * -1;

    return (laterHours + Integer.parseInt(earlyHoursAndMins[0])) * 60
        + laterMinutes
        + Integer.parseInt(earlyHoursAndMins[1]);
  }

  public static void main(String[] args) {
    var mtd = new MinimumTimeDifference();

    List<String> list = new ArrayList<>();

    list.add("23:59");
    list.add("00:00");

    System.out.println(mtd.findMinDifference(list));
  }
}
