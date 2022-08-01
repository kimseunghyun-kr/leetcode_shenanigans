import java.math.BigInteger;

public class UniquePath62 {
    // public int uniquePaths(int m, int n) {
    // return factorial((m-1) +
    // (n-1)).divide((factorial(n-1).multiply(factorial(m-1)))).intValue();
    // }

    // public BigInteger factorial(int x) {
    // BigInteger ans = BigInteger.valueOf(1);
    // for(int i = 1; i<= x ; i++) {

    // ans = ans.multiply(BigInteger.valueOf(i));
    // }
    // return ans;
    // }

    // public int uniquePaths(int m, int n) {
    // int numerator = m-1 + n-1;
    // long result = 1;
    // int divisor = 1;
    // for(int i = 1; i <= numerator; i++) {
    // if(i <= m-1) {

    // } else {
    // result = result * i / divisor;
    // divisor++;
    // }
    // }

    // return (int) result;

    // }

    public int uniquePaths(int m, int n) {
        int[] dpArr = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0)
                    dpArr[j] = 1;
                else {
                    if (j == 0)
                        dpArr[j] = 1;
                    else {
                        dpArr[j] = dpArr[j] + dpArr[j - 1];
                    }
                }
            }
        }

        return dpArr[n - 1];

    }

    public static void main(String[] args) {
        UniquePath62 test = new UniquePath62();
        int ans = test.uniquePaths(3, 7);
        System.out.println(ans);
    }
}
