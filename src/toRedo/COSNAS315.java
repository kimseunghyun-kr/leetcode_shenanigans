package toRedo;

import java.util.Arrays;
import java.util.List;

public class COSNAS315 {

//    how i would have done
//    use a range/ segment tree where the inputs are inverted, and
//    according to the tree, the parent is the number of larger elements on the left(for the tree)
//    but implementation is tough here
//    todo later

//mergesort method  -> n^2 due to merge being n^2

    Integer[] count;
    int[] targetArray;
public List<Integer> countSmaller(int[] nums) {
    count = new Integer[nums.length];
    targetArray = nums;
    mergesort(0, nums.length);

    return Arrays.asList(count);
}

public void mergesort (int start, int end) {
    if(start >= end) {
        return;
    }
    int mid = (end - start) /2;
    mergesort(start, mid);
    mergesort(mid, end);
    merge(start, mid ,end);

    return;
}

public void merge ( int start, int mid, int end) {
    for(int i = start ; i < mid ; i++) {
        int left = targetArray[i];
        for (int j = mid; j < end; j++) {
            int right = targetArray[j];
            if(left > right) {
                count[i]++;
            }
        }
    }
}


//    answer used fenwick trees.
//    public List<Integer> countSmaller(int[] nums) {
//        int min = 20001;
//        int max = -1;
//        for (int num : nums) {
//            min = Math.min(min, num);
//            max = Math.max(max, num);
//        }
//
//        min--;
//        int[] count = new int[max-min+1];
//        Integer[] result = new Integer[nums.length];
//        for (int i = nums.length-1; i >=0; i--) {
//            int k = nums[i]-min-1;
//            int c = 0;
//            do {
//                c += count[k];
//                k -= (-k&k);
//            } while (k > 0);
//            result[i] = c;
//
//            k = nums[i]-min;
//            while (k < count.length) {
//                count[k]++;
//                k += (-k&k);
//            }
//        }
//
//        return Arrays.asList(result);
//    }
}
