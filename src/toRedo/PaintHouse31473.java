package toRedo;

class PaintHouse31473 {

// incomplete -> did not pass this

    int[] houses;
    int[][] cost;
    int[][][] dpArr;
    int colNum;
    int target;
    int MaxDef = (int)Math.pow(10,6);

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.dpArr = new int[m][target][n];
        this.colNum = n;
        this.target = target;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < target ; j++) {
                for(int k = 0 ; k < n ; k++ ) {
                    dpArr[i][j][k] = MaxDef;
                }
            }

        }


        int currColour = houses[0] -1;
        if(currColour == -1) {
            for( int i = 0 ; i < n ; i++ ) {
                dpArr[0][0][i] = cost[0][i];
            }
        } else {
            dpArr[0][0][currColour] = 0;
        }


        minCostHelper(1,0);

        int result = MaxDef;

        for(int i = 0 ; i< n ; i++ ) {
            result = Math.min(result , dpArr[m-1][target-1][i]);
        }

        return result;
    }

    public void minCostHelper(int idx , int tar) {

        if(idx == houses.length || tar>=target) {
            return;
        }
        int currColour = houses[idx]-1;
        if( currColour == -1 ) {
            for(int newCol = 0 ; newCol < colNum ; newCol++) {
                for( int preCol = 0 ; preCol < colNum ; preCol ++ ) {
                    if(newCol == preCol) {
                        int minres3 =  Math.min(dpArr[idx][tar][newCol] , dpArr[idx-1][tar][preCol] + cost[idx][newCol]);
                        // System.out.println("idx " + idx + " tar " + tar + " minres " + minres3);
                        dpArr[idx][tar][newCol] = minres3;

                    } else {
                        if(tar+1 >=target) {
                            continue;
                        }
                        int minres4 = Math.min(dpArr[idx][tar+1][newCol] , dpArr[idx-1][tar][preCol] + cost[idx][newCol]);
                        // System.out.println("idx " + idx + " tar " + (tar+1) + " minres " + minres4);
                        dpArr[idx][tar+1][newCol] =  minres4;

                    }
                }
            }

            minCostHelper(idx+1, tar);
            minCostHelper(idx+1, tar+1);

        } else {
            int prevColour = houses[idx -1] -1;
            if(prevColour == -1 ) {

                //previous house colored 0
                for(int c = 0 ; c < colNum ; c++ ) {
                    if(c == currColour) {
                        // if prev house arbitrary colored same;
                        int minres5 = Math.min(	dpArr[idx][tar][currColour] ,dpArr[idx-1][tar][currColour]);
                        // System.out.println("idx " + idx + " tar " + tar + " minres " + minres5);
                        dpArr[idx][tar][currColour] = minres5;
                        minCostHelper(idx+1 , tar);
                    } else {
                        if(tar+1 >= target) {
                            continue;
                        }

                        // if prev house arbitrary colored diff
                        int minres =  Math.min( dpArr[idx-1][tar][c] ,  dpArr[idx][tar+1][currColour]);
                        // System.out.println("idx " + idx + " tar " + (tar+1) + " minres " + minres);
                        dpArr[idx][tar+1][currColour] = minres;
                        minCostHelper(idx+1, tar+1);
                    }


                }


            } else {

                //previous house colored something else than 0
                if(prevColour == currColour) {
                    //same color
                    int minres6 = Math.min(	dpArr[idx][tar][currColour] ,dpArr[idx-1][tar][currColour]);
                    // System.out.println("idx " + idx + " tar " + tar + " minres " + minres6);
                    dpArr[idx][tar][currColour] = minres6;
                    minCostHelper(idx+1, tar);

                } else {
                    //diff color;
                    if(tar + 1 >= target) {
                        return;
                    }

                    int minres2 =  Math.min(dpArr[idx][tar+1][currColour] ,dpArr[idx-1][tar][prevColour]);
                    // System.out.println("idx " + idx + " tar " + (tar+1) + " minres " + minres2);
                    dpArr[idx][tar+1][currColour] = minres2;
                    minCostHelper(idx+1,tar+1);

                }


            }
        }

    }
}