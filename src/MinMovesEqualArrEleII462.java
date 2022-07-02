import java.util.Arrays;

public class MinMovesEqualArrEleII462 {

    public int minMoves2(int[] nums) {
//         add up all element, find mean? -> doesnt work
//        1 1 1 1000 -> min is 999 not mean
//         median?
//        unsure of the maths but seems legit
        int median = quickSelectMedian(nums);

        int result = 0;
        for(int i : nums) {
            result += Math.abs(median - i);
        }

        return result;

    }


    int arrLen = Integer.MIN_VALUE;
    int oddAns = Integer.MIN_VALUE;
    int evenAns = Integer.MIN_VALUE;

    public int quickSelectMedian (int[] nums) {
        arrLen = nums.length;
        oddAns = Integer.MIN_VALUE;
        evenAns = Integer.MIN_VALUE;

        if(arrLen%2 == 1) {
            medianHelper(nums,0,arrLen-1,arrLen/2, true);
            return oddAns;
        } else {
            medianHelper(nums,0,arrLen-1,arrLen/2, false);
            return (oddAns+evenAns)/2;
        }
    }

    public int medianHelper(int[] nums, int left , int right, int desired, boolean odd) {

        if (left <= right) {
            int partitionRes = randomPartition(nums, 0 , right);
            if(partitionRes  == desired) {
                oddAns = nums[desired];
                if(odd) {
                    return -1;
                }
            } else if (partitionRes == desired-1) {
                evenAns = nums[partitionRes];
            }

            if(partitionRes >= desired) {
                return medianHelper(nums , left, partitionRes-1 , desired, odd);
            } else {
                return medianHelper(nums,partitionRes+1 , right , desired, odd);
            }
        }

        return oddAns;
    }

    public void swap(int[] nums, int swap1, int swap2) {
        int temp = nums[swap1];
        nums[swap1] = nums[swap2];
        nums[swap2] = temp;
    }

    public int partition (int[] nums, int lessThan, int moreThan, int tarIdx) {
        int tar = nums[tarIdx];
        int current = lessThan;

        //swapping the beginning and the tarIdx -> Dutch national flag method
        swap(nums,lessThan,tarIdx);

        while(current <= moreThan) {
            if(nums[current] < tar) {
                swap(nums,current,lessThan);
                current++;
                lessThan++;

            } else if (nums[current] == tar) {
                current++;
            } else {
                swap(nums,current,moreThan);
                moreThan--;
            }
        }

        return --current;
    }

    public int randomPartition(int[] arr, int leftBound , int rightBound) {
        int newSize = rightBound-leftBound+1;
        int pivot = (int)(Math.random()*newSize) + leftBound;
        return partition(arr, leftBound, rightBound , pivot);
    }


    //    or simply just
    public int minMoves3(int[] nums) {
//         add up all element, find mean? -> doesnt work
//        1 1 1 1000 -> min is 999 not mean
//         median?
//        unsure of the maths but seems legit

        Arrays.sort(nums);
        int result = 0;
        if(nums.length%2 == 1) {
            for(int i : nums) {
                result += Math.abs(nums[nums.length/2] - i);
            }
        } else {
            int median = (nums[nums.length/2] + nums[(nums.length-1)/2])/2;
            for(int i : nums) {
                result += Math.abs( median - i);
            }

        }

        return result;
    }

    public static void main(String[] args) {

        MinMovesEqualArrEleII462 test = new MinMovesEqualArrEleII462();
        int[] testArr = {1,1000};
        int quickSelectans = test.quickSelectMedian(testArr);
        System.out.println(quickSelectans);
//        int ans = test.minMoves2(testArr);
//        System.out.println(ans);
    }


}
