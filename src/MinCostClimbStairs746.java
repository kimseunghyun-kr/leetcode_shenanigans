public class MinCostClimbStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int[] dpArr = new int[cost.length];


        for(int i = 0 ; i < cost.length ; i++) {
            if(i == 0 || i == 1) {
                dpArr[i] = cost[i];
            } else {
                dpArr[i] = Integer.MAX_VALUE;
                for(int j = 1 ; j <= 2 ; j++) {
                    dpArr[i] = Math.min(dpArr[i],dpArr[i-j] + cost[i]);
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for(int i = 1 ; i <= 2 ; i++) {
            minCost = Math.min(minCost ,dpArr[cost.length-i] );
        }
        return minCost;
    }


}
