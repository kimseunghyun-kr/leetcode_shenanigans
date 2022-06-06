import java.util.PriorityQueue;

public class RickNMortyLadder {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y) -> y-x);

        int remainingBricks = bricks;
        int remainingLadders = ladders;
        for(int i = 0 ; i < heights.length ; i++) {

            if(remainingBricks < 0) {
//                remaining bricks less than or equals to 0
                if(remainingLadders <= 0) {
//                    ladder less than 0
                    return i-1;

                } else {
                    int bricksToAdd = pq.poll();
                    remainingLadders--;
                    remainingBricks +=bricksToAdd;
                    i--;
//                    ladder > 0
                }
            } else if (i == heights.length-1) {
                return i;
            }else {
//                bricks >0
                int diff = heights[i+1] - heights[i];
                int bricksNeeded = diff > 0 ? diff : 0;
                remainingBricks -= bricksNeeded;
                pq.add(bricksNeeded);

            }

        }
        return heights.length;
    }

    public static void main(String[] args) {
        RickNMortyLadder test = new RickNMortyLadder();
        int[] heights = {4,2,7,6,9,14,12};
        int[] heights2 = {4,12,2,7,3,18,20,3,19};
        int[] heights3 = {0,1};
        int ans = test.furthestBuilding(heights3,5,1);
        System.out.println(ans);
    }
}
