package crackingthecodeinterview.dp;

/*
Robot in a Grid:
Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells are "off limits" such
that the robot cannot step on them.  Design an algorithm to find a path for the robot from the top
left to the bottom right.
 */

public class Problem2 {
    String path = "";

    String solve(String[][] grid) {
        path = "";
        makeAMove(grid, 0, 0, "");
        return path;
    }

    private void makeAMove(String[][] grid, int xpos, int ypos, String moves) {
        if (!path.equals("")){
            return;
        }
        if (grid.length - 1 == xpos) {
            if (grid[0].length - 1 == ypos) {
                path = moves;
                return;
            }
            if (grid[xpos][ypos + 1].equals("")) {
                makeAMove(grid, xpos, ypos + 1, moves.concat("D"));
            }
        } else if (grid[0].length - 1 == ypos) {
            if (grid[xpos + 1][ypos].equals("")) {
                makeAMove(grid, xpos + 1, ypos, moves.concat("R"));
            }
        } else {
            if (grid[xpos][ypos + 1].equals("")) {
                makeAMove(grid, xpos, ypos + 1, moves.concat("D"));
            }
            if (grid[xpos + 1][ypos].equals("")) {
                makeAMove(grid, xpos + 1, ypos, moves.concat("R"));
            }
        }
    }

    public static void main(String[] args) {
        var grid1 = new String[][]{
                new String[]{"", "", ""},
                new String[]{"", "X", "X"},
                new String[]{"", "", ""}
        };

        var grid2 = new String[][]{
                new String[]{"", "", ""},
                new String[]{"", "X", ""},
                new String[]{"", "X", ""}
        };

        var grid3 = new String[][]{
                new String[]{"", "X", "X"},
                new String[]{"", "", ""},
                new String[]{"X", "", ""}
        };

        var grid4 = new String[][]{
                new String[]{"", "X", "X", "X"},
                new String[]{"", "", "", ""},
                new String[]{"X", "X", "X", ""},
                new String[]{"", "", "", ""}
        };

        Problem2 p2 = new Problem2();

        var sol1 = p2.solve(grid1);
        var sol2 = p2.solve(grid2);
        var sol3 = p2.solve(grid3);
        var sol4 = p2.solve(grid4);

        System.out.println("Testcase: ".concat(String.valueOf("RRDD".equals(sol1))));
        System.out.println(sol2);
        System.out.println("Testcase: ".concat(String.valueOf("DDRR".equals(sol2))));
        System.out.println(sol3);
        System.out.println("Testcase: ".concat(String.valueOf("RDDR".equals(sol3))));
        System.out.println(sol4);
        System.out.println("Testcase: ".concat(String.valueOf("RDDDRR".equals(sol4))));
    }
}
