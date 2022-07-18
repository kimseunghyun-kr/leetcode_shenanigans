class Sudokuish1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] prefixSummedMatrix = matrix;
        for(int i = 0; i< matrix.length ; i++) {
            for(int j = 0 ; j< matrix[0].length ; j++) {
                if(j == 0) {
                    prefixSummedMatrix[i][j] = matrix[i][j]
                } else {
                    prefixSummedMatrix[i][j] = prefixSummedMatrix[i][j-1] + matrix[i][j];
                }
                // if(j == 0 || i == 0) {
                //     if(i == 0 && j == 0) prefixSummedMatrix[i][j] = matrix[i][j];
                //     if(i == 0) prefixSummedMatrix[i][j]  = prefixSummedMatrix[i][j-1] + matrix[i][j];
                //     if(j == 0) prefixSummedMatrix[i][j] = prefixSummedMatrix[i-1][j] + matrix[i][j];
                // } else {
                //     prefixSummedMatrix[i][j] = prefixSummedMatrix[i][j-1] + prefixSummedMatrix[i-1][j] + matrix[i][j];
                // }
            }
        }

        int count = 0;

        for(int i = 0; i< matrix[0].length ; i++) {
            for(int j = i+1 ; j< matrix[0].length ; j++) {
                int sumofSubMatrix = 0;

                for(int row = 0; row < matrix.length ; row++) {
                    sumofSubMatrix = sumofSubMatrix + prefixSummedMatrix[row][j] - prefixSummedMatrix[row][i];
                    if(sumofSubMatrix-target == 0) {
                        count += 1;
                    }

                    // remaining is omitted to try next time; -> weekends probably
                }

            }
        }
    }
    
}


// https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/discuss/803353/Java-Solution-with-Detailed-Explanation


0 1 0    -> 0 1 1
-1 1 0   -> -1 0 0
1 5 -7   -> 1 6 -1