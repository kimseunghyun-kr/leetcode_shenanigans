package leetcode_shenanigans.src.toRedo;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

class MatchSticksToSquares473 {

    
    int barrier;
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length<4) {
            return false;
        } else {
            int sum = 0;
            for(int i : matchsticks) {
                sum+=i;
            }
            
            if(sum%4 != 0) {
                return false;
            } else {
                barrier = sum /4;
                Integer[] matchSticks = IntStream.of( matchsticks ).boxed().toArray( Integer[]::new );
        Arrays.sort(matchSticks, Collections.reverseOrder());
        return helper(matchSticks , 0,0,0,0,0);
                // boolean[] used = new boolean[matchsticks.length];
                // return helper(matchsticks , used , sum/4 , 0 , 4);
            }
        }
        
    }
    
    
    
    // public boolean helper(int[] matchsticks, boolean[] usedsticks, int target, int currsum, int remainingsides) {
    //     if(remainingsides == 0) {
    //         return true;
    //     } else {
    //         if(currsum == target) {
    //             return helper(matchsticks, usedsticks, target, 0 , remainingsticks--);
    //         } else {
    //             if()
    //         }
    //     }
    // }
    
    public boolean helper(Integer[] matchsticks, int i, int j , int k , int l, int idx) {
        
        if(idx == matchsticks.length && i == j  && k == l && j == k) {
            return true;
        } else if (idx == matchsticks.length || i> barrier || j>barrier || k> barrier || l > barrier) {
            return false;
        } else {
            boolean toSide1 = helper(matchsticks , i  + matchsticks[idx] , j, k, l, idx+1);
            if(toSide1) {
                return true;
            }
            boolean toSide2 = helper(matchsticks , i  , j + matchsticks[idx], k, l, idx+1);
            if(toSide2) {
                return true;
            }
            boolean toSide3 = helper(matchsticks , i  , j, k + matchsticks[idx], l, idx+1);
            if(toSide3) {
                return true;
            }
            boolean toSide4 = helper(matchsticks , i  , j, k, l + matchsticks[idx], idx+1);
            if(toSide4) {
                return true;
            }
            
            return false;
        }
    }
}
