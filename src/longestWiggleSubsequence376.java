import java.util.ArrayList;
import java.util.HashSet;

public class longestWiggleSubsequence376 {

    public int wiggleMaxLength(int[] nums) {
//        let n be the size of nums
//        make a n-1 sized arr containing the differences;
//        for the array, find the longest subsequence of alternation

//        longest subsequence of alternation
//        start from the end, if next is opp sign, then longest subsequence length ++;
//        would result in n^2 for all n-1 indexes, do O(n) oper on each;

//        or note that when a continuouus subsequence ends, for those indexes, the longest subsequence possible is fixed;
        ArrayList<Integer> longestSubSeq = new ArrayList<>();

        int prevNum = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if (nums.length == 1) {
                return 1;
            } else {
                if (i == 0) {
                    continue;
                }
                int currNum = Integer.compare(nums[i] - nums[i - 1], 0);
                if (i == 1) {
                    longestSubSeq.add(nums[0]);
                    if (currNum != 0) {
                        longestSubSeq.add(nums[1]);
                    }
                    prevNum = currNum;
                } else {
                    if(currNum == 0 || currNum == prevNum) {

                    } else {
                        longestSubSeq.add(nums[i]);
                        prevNum = currNum;
                    }
//                    if((currNum > 0 && prevNum <= 0) || (currNum < 0 && prevNum>= 0)) {
//
//                    }
                }


            }
        }

        return longestSubSeq.size();
    }

    public static void main(String[] args) {
        longestWiggleSubsequence376 test = new longestWiggleSubsequence376();
        int[] testArr1 = {1,2,3,4,5,6,7,8,9};
        int ans = test.wiggleMaxLength(testArr1);
        System.out.println(ans);
    }

}

































//        understood qn wrongly
//        int[] differenceArr = new int[nums.length-1];
//
//        for(int i = 1 ; i<nums.length ; i++ ) {
//            differenceArr[i-1] = nums[i] - nums[i-1];
//        }
//
//        ArrayList<Integer> subSeqBreakSet = new ArrayList<>();
//        int prevNum = 0;
//        int subSeqBreakIdx = 0;
//
//        for(int j = 0; j < differenceArr.length ; j++) {
//            if(j == 0) {
////                prevNum = differenceArr[j] < 0 ? -1 : differenceArr[j] == 0 ? 0 : 1;
//                prevNum = Integer.compare(differenceArr[j], 0);
//                subSeqBreakIdx++;
//                if(prevNum == 0) {
//                    subSeqBreakSet.add(subSeqBreakIdx);
//                }
//            } else {
//                int currNum = Integer.compare(differenceArr[j], 0);
//                if(currNum == 0) {
//                    if(subSeqBreakSet.get(subSeqBreakSet.size()-1) != subSeqBreakIdx) {
//                        subSeqBreakSet.add(subSeqBreakIdx);
//                    }
//                    subSeqBreakIdx++;
//                    subSeqBreakSet.add(subSeqBreakIdx);
//                } else if(currNum == prevNum) {
//                    subSeqBreakSet.add(subSeqBreakIdx);
//                    subSeqBreakIdx++;
//                } else {
//                    prevNum = currNum;
//                    subSeqBreakIdx++;
//                }
//            }
//        }
//
//        subSeqBreakSet.add(subSeqBreakIdx);
//
//        int lastBreak = -1;
//        int maxSubSeq = 0;
//        for(int i = 0 ; i < subSeqBreakSet.size() ; i++) {
//            maxSubSeq = Math.max(maxSubSeq, subSeqBreakSet.get(i)-lastBreak);
//            lastBreak = subSeqBreakSet.get(i);
//        }
//
//        return maxSubSeq;
//
//    }
//
//
//    public static void main(String[] args) {
//        longestWiggleSubsequence376 test = new longestWiggleSubsequence376();
//        int[] testArr1 = {1,17,5,10,13,15,10,5,16,8};
//        int ans = test.wiggleMaxLength(testArr1);
//        System.out.println(ans);
//    }
//}
// {1,7,4,9,2,5};
//[1,17,5,10,13,15,10,5,16,8]