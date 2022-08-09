import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class BinTreeFact823 {
    final int T = 1_000_000_007;
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
//        for all int i in arr, i > 1 and i distinct

//        find no of bin tree st
//        bin tree node != leaf = lc * rc
//        bin tree node c i;

        long TreeNum = arr.length;
        long[] rootStore = new long[arr.length];
        HashMap<Long, Integer> leafStore = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            leafStore.put((long) arr[i], i);
            rootStore[i] = 1;
        }

        for (int i = 0; i < arr.length; i++) { //left
            for (int j = 0; j <= i; j++) { //right
                boolean contains = leafStore.containsKey((long)arr[i] * (long)arr[j]);
                if (contains) {
//                    TreeNum += rootStore[i] * rootStore[j];
//                    rootStore[leafStore.get(arr[i] * arr[j])] += rootStore[i] * rootStore[j];
                    if (i == j) {
                        TreeNum += (rootStore[i] * rootStore[j])%T;
                        rootStore[leafStore.get((long)arr[i] * (long)arr[j])] += (rootStore[i] * rootStore[j])%T;
                    } else {
                        TreeNum += (2 * (rootStore[i] * rootStore[j])%T)%T;
                        rootStore[leafStore.get((long)arr[i] * (long)arr[j])] += (2 * (rootStore[i] * rootStore[j])%T)%T;
                    }
                }
            }
        }
        return (int)(TreeNum %T);
    }

    public static void main(String[] args) {
        BinTreeFact823 test = new BinTreeFact823();
        int ans = test.numFactoredBinaryTrees(new int[] {45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48});
        System.out.println(ans);
    }

}
//[45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48]