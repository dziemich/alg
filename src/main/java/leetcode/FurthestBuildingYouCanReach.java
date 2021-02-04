package leetcode;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(ladders, Integer::compare);

    int counter = 0;
    int last = heights[0];

    for (int i = 1; i < heights.length; i++) {

      if (last >= heights[i]) {
        counter++;
      } else {
        int diff = heights[i] - last;
        if (pq.size() != ladders) {
          pq.offer(diff);
        } else {
          int lowestLadder = pq.peek();
          int bricksToUse = Math.min(lowestLadder, diff);
          bricks -= bricksToUse;
          if (bricks < 0) return counter;

          if (lowestLadder < diff) {
            pq.poll();
            pq.offer(diff);
          }
        }
        counter++;
      }
      last = heights[i];
    }

    return counter;
  }

  public static void main(String[] args) {
    var fbycr = new FurthestBuildingYouCanReach();

    int i = fbycr.furthestBuilding(new int[] {4, 2, 7, 6, 9, 14, 12}, 5, 1);
    System.out.println("D: " + i);
  }
}
