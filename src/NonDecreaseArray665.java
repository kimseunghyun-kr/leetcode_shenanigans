public class NonDecreaseArray665 {

//discussion soln -> key takeaway = apply the nums[i-1] = nums[i] from i = 1;
//    public boolean checkPossibility(int[] nums) {
//        int modified = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] < nums[i - 1]) {
//                if (modified++ > 0) return false;
//                if (i - 2 < 0 || nums[i - 2] <= nums[i])
//                    nums[i - 1] = nums[i];
//                else nums[i] = nums[i - 1];
//            }
//        }
//        return true;
//    }

    public boolean checkPossibility(int[] nums) {

        int changeNeeded = 0;
        int prev = nums[0];

        for (int i = 0 ; i < nums.length ; i++) {

            if(i>1) {
                if(nums[i-2]>nums[i-1] && nums[i-1]>nums[i]) {
                    return false;
                } else if(nums[i-2]<=nums[i-1] && nums[i-1]>nums[i]) {
                    changeNeeded++;
                    if(nums[i]>=nums[i-2]) {
                        nums[i-1] = nums[i];
                    } else {
                        nums[i] = nums[i-1];
                    }
                } else if (nums[i-2]>nums[i-1] && nums[i]>nums[i-1]) {
                    changeNeeded++;
                    nums[i-2] = nums[i-1];
                } else {
                    continue;
                }
            }

            if(changeNeeded > 1) {
                return false;
            }
            prev = nums[i];
        }

        return true;
    }

    public static void main(String[] args) {
        int[] test = {12,8,15,11,13,14};
        NonDecreaseArray665 tests = new NonDecreaseArray665();
        boolean ans = tests.checkPossibility(test);
        System.out.println(ans);
    }
}
