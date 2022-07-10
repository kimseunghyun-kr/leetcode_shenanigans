package toRedo;

import java.util.PriorityQueue;

public class JumpGameVI1696 {


//    to redo

    //    k = 2
//            10 -2 -5 -100 7



    //fails
    Integer[] dpArr;
    public int maxResult(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        dpArr = new Integer[nums.length];

        return MaxRecurser(nums,0,k);

    }


    public int MaxRecurser (int[] nums, int currI, int k) {
        if(currI >= nums.length) {
            return (int) -1e9;
        }

        if(currI == nums.length-1) {
            return dpArr[currI] =  nums[currI];
        }

        if(dpArr[currI] != null) {
            return dpArr[currI];
        }

        else {

            int maxresult = Integer.MIN_VALUE;
            for(int i = 0 ; i < k ; i++) {

                int result = MaxRecurser(nums, currI + (i+1) , k);
                maxresult = Math.max(maxresult , result);
            }

            return dpArr[currI] =  nums[currI] + maxresult;
        }
    }

    public static void main(String[] args) {
        int[] test1 = {1, 2,4,5,-3};

        JumpGameVI1696 tester = new JumpGameVI1696();
        int ans = tester.maxResult(test1 , 2);
        System.out.println(ans);
    }


//referred ans

//    public int maxResult(int[] nums, int k)
//    {
//        int n = nums.length;
//        int dp[] = new int[n];
//
//        Deque<Integer> dq = new LinkedList<>();
//
//        for(int i=0;i<n;i++)
//        {
//            if(i==0){
//                dq.add(0);
//                dp[i] = nums[0];
//                continue;
//            }
//
//            while(dq.peekFirst() < (i-k)) dq.pollFirst();
//
//            int max = dp[dq.peekFirst()];
//            dp[i] = nums[i] + max;
//
//            while(!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) dq.pollLast();
//
//            dq.addLast(i);
//        }
//
//        return  dp[n-1];
//    }

//    public int maxResult(int[] nums, int k) {
//        dpArr= new int[nums.length][k];
//        this.nums = nums;
//
//        return jumpRecurser(0,0);
//    }
//
//    public int jumpRecurser(int i, int sumOfNum) {
//        if(i >= nums.length) {
//            return 0;
//        }
//
//        if(i == nums.length -1) {
//            return nums[i];
//        }
//
//
//        int Min = Integer.MIN_VALUE;
//        for(int j = 0 ; j < nums.length ; j++) {
//            Min = Math.max(Min , jumpRecurser(i , sumOfNum + nums[i]));
//        }
//
//        return Min;
//    }

}
