package toRedo;

public class KInvPairArray629 {
//    let there exist an int[] nums
//    if intpair [i, j] where 0<=i<j<nums.length
//            && nums[i]>nums[j],
//    pair -> inverse pair of array nums;

//    -> situation where i < j (idx) but nums[i]>nums[j];


//    -> not situation that is required to return the number
//    of different array where nums[i], nums[j] is between 1, n;

//    though not sure if repeat numbers in arr is possible -> i.e -> {3,3,3};


//     -> begin with a sorted increasing arr --> has 0 inv pair
//     -> when 1 swap between adj pairs occur, arr has 1 inv pair
//     -> or in this case -> the number of total displacements of the shifted numbers


//    what i failed to grasp

//    if a new elem is added -> i.e , if at the right (0 disp) , it will not affect k
//    similarly, the above rule also applies to the newly added element,
//    where the total number of inverse pairs = original displacement total sum + new element displacement


//    where the original displacement sum will now be called count(a,b) for
//    an arbitrary a,b st a <= n and b <= k;


//    if this is the case ->

//    count(0,k) = 0 as there are no numbers to be sorted
//    count (n,0) = only 1 as established above
//    count(a,b) = sum, from g = 0 to g = min(n-1, k)
//    count(n-1,k-g);
//    above spans from the logic that
//    say k = 4
//    i.e) n=4 -> can be 1234 -> if n becoming 5, the 5 being placed is max
//    displaced by min(k, n-1) -> 51234

//    the k-g is because instances like 2431 requires the 5 to be put at the end;

//    further reference at
//https://leetcode.com/problems/k-inverse-pairs-array/solution/




    public int kInversePairs(int n, int k) {
        int[] initialDpArr;
        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            int[] newDPArr = new int[k+1];
            for(int j = 0 ; j < k+1 ; j++) {
                if(j == 0) {
                    newDPArr[j] = 1;
                } else {

                    if(j-i > 0) {
                        newDPArr[j] = newDPArr[j - 1] + (initialDpArr[j] - initialDpArr[j-i]);
                    } else {
                        newDPArr[j] = newDPArr[j - 1] + initialDpArr[j];
                    }

                    if(i == n-1) {
                        ans += newDPArr[j];
                    }
                }
            }
            initialDpArr = newDPArr;
        }

    }
}
