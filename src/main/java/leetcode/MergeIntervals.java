package leetcode;

import java.util.*;

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {

    List<int[]> ans = new ArrayList<>();


    Arrays.sort(
            intervals,
            (a, b) -> {
              if (a[0] == b[0]) return a[1] - b[1];
              else return a[0] - b[0];
            });

    int[] last = intervals[0];

    for(int i = 1; i < intervals.length; i++){
      int[] current = intervals[i];

      if(last[1] < current[0]){
        ans.add(last);
        last = current;
      } else {
        last = new int[]{last[0], Math.max(last[1], current[1])};
      }
    }

    ans.add(last);


    return ans.toArray(new int[0][0]);
  }

  public static void main(String[] args) {
    var mi = new MergeIntervals();
    //
//    int[][] merge = mi.merge(new int[][] {new int[] {1, 4}, new int[] {4,5}});
    //
    //    System.out.println("X");
    mi.merge(
        new int[][] {
          new int[] {2, 3},
          new int[] {5,5},
          new int[] {2,2},
          new int[] {3,4},
          new int[] {3,4}
        });

//    mi.merge(
//        new int[][] {
//          new int[] {2, 3},
//          new int[] {2, 2},
//          new int[] {3, 3},
//          new int[] {1, 3},
//          new int[] {5, 7},
//          new int[] {2, 2},
//          new int[] {4, 6}
//        });
  }

  // [[2,3],[2,2],[3,3],[1,3],[5,7],[2,2],[4,6]]
}
