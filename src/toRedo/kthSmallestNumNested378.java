import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallestNumNested378 {

    public int kthSmallest(int[][] matrix, int k) {
    //2d binsearch -> exercept from meganLee https://leetcode.com/meganlee/

    int rows = matrix.length, cols = matrix[0].length;
        
        int lo = matrix[0][0], hi = matrix[rows - 1][cols - 1] ;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  maxNum = lo;
           
            for (int r = 0, c = cols - 1; r < rows; r++) {
                while (c >= 0 && matrix[r][c] > mid) c--;   
                
                if (c >= 0) {
                    count += (c + 1); // count of nums <= mid in matrix
                    maxNum = Math.max(maxNum, matrix[r][c]); 
         // mid might be value not in  matrix, we need to record the actually max num;
                }else{ //it means c < 0
                    break;
                } 
            }
            
            // adjust search range
            if (count == k) return maxNum;
            else if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    }
    // public int kthSmallest(int[][] matrix, int k) {
    //     //pq method
    //     PriorityQueue<Integer> KsizeQ = new PriorityQueue<>(k,Collections.reverseOrder());
    //     int len = matrix.length;
    //     for(int i = 0 ; i < len ; i++) {
    //         for(int j = 0 ; j<len; j++) {
    //             if(KsizeQ.size()<k) {
    //                 KsizeQ.add(matrix[i][j]);
    //             } else {
    //                 int currbiggest = KsizeQ.peek();
    //                 if(matrix[i][j] < currbiggest) {
    //                     KsizeQ.poll();
    //                     KsizeQ.add(matrix[i][j]);
    //                 }
    //             }
    //         }
    //     }

    //     return KsizeQ.poll();
    // }
}
