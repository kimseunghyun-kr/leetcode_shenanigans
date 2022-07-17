package toRedo;

public class OutOfBoundaryPath576 {

    final long Mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        long numPath = 0;


//        2-D dpdp array to store the number of ways in which a particular position can be reached.
        long[][] mainDpArr = new long[m][n];


//        mainDpArr[startRow][startColumn] = 1;

        for(int steps = 0 ; steps <= maxMove ; steps++) {
//            next-gen of main Arr
            long[][] dpArr = new long[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (steps == 0) {
                        if (i == startRow && j == startColumn) {
                            dpArr[i][j] = 1;
                        } else {
                            dpArr[i][j] = 0;
                        }
                    } else {

                        if (i == m - 1) numPath = (numPath + mainDpArr[i][j]) % Mod;
                        if (j == n - 1) numPath = (numPath + mainDpArr[i][j]) % Mod;
                        if (i == 0) numPath = (numPath + mainDpArr[i][j]) % Mod;
                        if (j == 0) numPath = (numPath + mainDpArr[i][j]) % Mod;

//                    must account for all occurences
//                    if(i == m-1 || i == 0 || j == 0 || j == n-1) {
//                        numPath += dpArr[i][j] % Mod;
//                    }
                        if (i > 0) {
                            dpArr[i][j]  = (dpArr[i][j] + mainDpArr[i - 1][j])%Mod;
                        }
                        if (i < m - 1) {
                            dpArr[i][j]  = (dpArr[i][j] + mainDpArr[i + 1][j])%Mod;
                        }
                        if (j > 0) {
                            dpArr[i][j]  = (dpArr[i][j] + mainDpArr[i][j - 1])%Mod;
                        }
                        if (j < n - 1) {
                            dpArr[i][j]  = (dpArr[i][j] + mainDpArr[i][j + 1])%Mod;
                        }

                    }
                }
            }

//            System.out.println("steps : " + steps + "   NumPath : " + numPath);
            mainDpArr = dpArr;

        }

        return (int)(numPath % (Mod));
    }

    public static void main(String[] args) {
        OutOfBoundaryPath576 test = new OutOfBoundaryPath576();
        int ans = test.findPaths(36,
                5,
                50,
                15,
                3);
        System.out.println(ans);
    }

}
