import java.util.Arrays;
import java.util.HashMap;

public class IslandMaxArea695 {

    class intStore {
        int x;

        public intStore(int x) {
            this.x = x;
        }
    }

    /*
     * concept should work in theory but i am not sure why when yMinus1 = xMinus1
     * executes, it does not change the value of the coord 1 less in y dir -> some mutability hacks needed
     */
    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;

        }

        @Override
        public boolean equals(Object o) {

            if (o instanceof Point) {
                Point p = (Point) o;
                return p.x == this.x && p.y == this.y;
            } else {
                return false;
            }

        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + (int) x;
            hash = 31 * hash + (int) y;
            return hash;
        }

        @Override
        public String toString() {
            return String.format("x : %d | y : %d", this.x, this.y);
        }
    }

    Boolean[][] seen;

    public int maxAreaOfIsland(int[][] grid) {
        seen = new Boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                seen[i][j] = false;
            }
        }
        
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (seen[i][j] == true) {

                } else {
                    if (grid[i][j] == 1) {
                        int result = recurser(i, j, grid);
                        ans = Math.max(ans, result);
                    }
                    seen[i][j] = true;
                    
                }
            }
        }
        return ans;
    }

    public int recurser(int i , int j, int[][] grid) {
        if( i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return 0;
        }
        if(seen[i][j] == true) {
            return 0;
        } 
        seen[i][j] = true;
        if (grid[i][j] == 0) {
            return 0;
        } else {
            return 1 + recurser(i+1, j, grid) + recurser(i , j+1, grid) + recurser(i-1, j, grid) + recurser( i , j-1 , grid);
        }
    }

    // public int maxAreaOfIsland(int[][] grid) {
    // HashMap<Point, intStore> islandUF = new HashMap<>();

    // int maxSize = 0;
    // int[] temp = {0};

    // for (int i = 0; i < grid.length; i++) {
    // for (int j = 0; j < grid[0].length; j++) {
    // System.out.println("=================");
    // if (grid[i][j] != 0) {

    // Point coords = new Point(j, i);

    // // int newSize = 0;
    // intStore defval = new intStore(0);

    // coords.x = coords.x - 1;
    // intStore xMinus1 = islandUF.getOrDefault(coords, defval);
    // coords.x = coords.x + 1;

    // coords.y = coords.y - 1;
    // intStore yMinus1 = islandUF.getOrDefault(coords, defval);
    // coords.y = coords.y + 1;

    // boolean isSame = xMinus1 == yMinus1;
    // System.out.print("i " + i + " j " + j + " " + isSame + " ");

    // if(xMinus1 == yMinus1) {
    // xMinus1.x = xMinus1.x + 1;
    // } else {
    // xMinus1.x = xMinus1.x + 1 + yMinus1.x;
    // yMinus1.x = xMinus1.x;
    // }

    // islandUF.put(coords, xMinus1);

    // System.out.println(xMinus1.x);
    // maxSize = Math.max(xMinus1.x, maxSize);
    // // yMinus1 = xMinus1;

    // if(i-1 >= 0 && grid[i-1][j] != 0) {
    // Point newCd = new Point(j, i-1);
    // intStore temper = islandUF.get(newCd);
    // temper = xMinus1;
    // }

    // }

    // // int[] temp = {0};
    // // System.out.println("!" + islandUF.getOrDefault(new Point(1,1), temp )[0]);
    // }

    // }

    // return maxSize;
    // }

    public static void main(String[] args) {
        IslandMaxArea695 test = new IslandMaxArea695();
        int[][] grid = { { 1, 0, 1 }, { 1, 1, 1 }, { 0, 1, 1 } };
        int ans = test.maxAreaOfIsland(grid);
        System.out.println(ans);

        // Hashtable<int[] , Integer> testHash = new Hashtable<>();
        // testHash.put(new int[]{0,0},1);
        // System.out.println(testHash.get(new int[] {0,0}));

        // int[] a1 = {0,0};
        // int[] a2 = {0,0};
        // System.out.println(a1.equals(a2));
    }
}
