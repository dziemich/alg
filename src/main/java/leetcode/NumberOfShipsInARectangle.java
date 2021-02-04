package leetcode;

interface Sea {
  boolean hasShips(int[] bl, int[] tr);
}

public class NumberOfShipsInARectangle {

  public int countShips(Sea sea, int[] bottomLeft, int[] topRight) {

    /*
    -----------
    | tl | tr |
    -----------
    | bl | br |
    -----------
     */

    int xMid = bottomLeft[0] + (topRight[0] - bottomLeft[0]) / 2;
    int yMid = bottomLeft[1] + (topRight[1] - bottomLeft[1]) / 2;

    int tl = 0, tr = 0, bl = 0, br = 0;

    int[] middle = {xMid, yMid};

    if (sea.hasShips(bottomLeft, middle)) {
      bl = countShips(sea, bottomLeft, middle);
    }

    if (sea.hasShips(new int[] {bottomLeft[0], yMid}, new int[] {xMid, topRight[1]})) {
      tl = countShips(sea, new int[] {bottomLeft[0], yMid}, new int[] {xMid, topRight[1]});
    }

    if (sea.hasShips(new int[] {xMid + 1, bottomLeft[1]}, new int[] {topRight[0], yMid + 1})) {
      br = countShips(sea, new int[] {xMid + 1, bottomLeft[1]}, new int[] {topRight[0], yMid + 1});
    }

    if (sea.hasShips(new int[] {xMid + 1, yMid + 1}, topRight)) {
      tr = countShips(sea, new int[] {xMid + 1, yMid + 1}, topRight);
    }

    return tl + tr + bl + br;
  }
}
