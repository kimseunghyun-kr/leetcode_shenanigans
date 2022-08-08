package toRedo;

public class LIS300 {
    public int lengthOfLISDP(int[] nums) {
        //dp approach. start from front. if nums[i] > nums[j] then dp[i] = max(dp[i], dp[j] +1), ans = Math.max(ans, dp[i]);
        return 0;
    }


    //binary search method and increasing arr method --> too beautiful and masterful. TO redo
    //source : https://leetcode.com/problems/longest-increasing-subsequence/discuss/74824/JavaPython-Binary-search-O(nlogn)-time-with-explanation
//    by diet pepsi
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) { //bin search for tails[m] < x. tail is an increasing arr.
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }
}

