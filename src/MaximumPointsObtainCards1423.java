public class MaximumPointsObtainCards1423 {
    public int maxScore(int[] cardPoints, int k) {

        if(cardPoints.length == 1) {
            return cardPoints[0];
        }
        int n = cardPoints.length;

        int[] slidingWindow = new int[n];
        slidingWindow[0] = cardPoints[0];
        //prefix arr

        for(int i = 1 ; i < n ; i++) {
            slidingWindow[i] = cardPoints[i] + slidingWindow[i-1];
        }

        int sumOfArr = slidingWindow[n-1];

        if(k == n) {
            return sumOfArr;
        }

        int maxRes = Integer.MIN_VALUE;
        for(int j = 0; j<=k ; j++) {
            int top = slidingWindow[n-1-(k-j)];
            int bot = j-1<0 ? 0 : slidingWindow[j-1];
            maxRes = Math.max(maxRes,sumOfArr-(top-bot));
        }

        return maxRes;
    }

    public static void main(String[] args) {
        MaximumPointsObtainCards1423 test = new MaximumPointsObtainCards1423();
        int[] testArr = {1,2,3,4,5,6,1};
        int ans = test.maxScore(testArr,1);
        System.out.println(ans);
    }
}
