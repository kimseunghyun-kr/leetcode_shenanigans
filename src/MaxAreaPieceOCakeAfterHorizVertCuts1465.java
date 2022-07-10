import java.util.Arrays;

public class MaxAreaPieceOCakeAfterHorizVertCuts1465 {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHorizInterval = findMaxInterval(horizontalCuts, h);
        int maxVertInterval = findMaxInterval(verticalCuts, w);

        long maxArea = (long) maxVertInterval * maxHorizInterval;
//        need to (long) because if maxVertInterval binary is being operated on.
//        if int, will overflow;

        return (int) (maxArea % 1000000007);

    }

    public int findMaxInterval(int[] cutArr, int totalLength) {
        int maxInterval = 0;
        int PrevCut = 0;

        for(int i : cutArr) {
            maxInterval = Math.max(maxInterval , i-PrevCut);
            PrevCut = i;
        }

        return maxInterval = Math.max(maxInterval , totalLength-PrevCut);
    }

    public static void main(String[] args) {
        MaxAreaPieceOCakeAfterHorizVertCuts1465 test = new MaxAreaPieceOCakeAfterHorizVertCuts1465();
        int[] testArr1 = {2};
        int ans = test.maxArea(1000000000,1000000000, testArr1, testArr1);
        System.out.println(ans);
    }
}
