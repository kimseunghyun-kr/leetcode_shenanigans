public class ComSumIV377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dpArr = new int[target + 1];

        for(int i = 0 ; i <= target ; i++) {

            if(i == 0) {
                dpArr[i] = 0; //is a placeholder to make things look appealing
            } else {

                for (int j = 0; j < nums.length; j++) {
                    int toAdd = nums[j];

                    if (i - toAdd == 0) {
                        dpArr[i] += 1;
                    } else if (i - toAdd > 0) {
                        dpArr[i] = dpArr[i] + dpArr[i - toAdd];
                    } else {
                        continue;
                    }

                }
            }
        }

        return dpArr[target];
    }

    public static void main(String[] args) {
        ComSumIV377 test = new ComSumIV377();
        int ans = test.combinationSum4(new int[] {1,2,3} , 4);
        System.out.println(ans);
    }
}
