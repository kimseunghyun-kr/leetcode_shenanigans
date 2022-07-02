import java.util.Arrays;
import java.util.HashMap;

public class MinDeltoMakeCharFreqUnique1647 {
    public int minDeletions(String s) {
        HashMap<Integer,Character> IntCharMap = new HashMap<>();
        char[] charArr = s.toCharArray();
        Arrays.sort(charArr);

        char currChar = charArr[0];
        int start = 0;
        int delChar = 0;
        for(int i = 0 ; i < charArr.length ; i++) {
            if(charArr[i] != currChar) {
                int freq = i-start;

                while(IntCharMap.containsKey(freq) && freq > 0) {
                    delChar++;
                    freq--;
                }
                currChar = charArr[i];
                start = i;
                i--;

                if(freq > 0) {
                    IntCharMap.put(freq, currChar);
                }
            }

            if(i == charArr.length-1) {
                int lastCharFreq = i - start + 1;
                while(IntCharMap.containsKey(lastCharFreq) && lastCharFreq>0) {
                    delChar++;
                    lastCharFreq--;
                }
            }
        }
        return delChar;
    }

    public static void main(String[] args) {
        MinDeltoMakeCharFreqUnique1647 test = new MinDeltoMakeCharFreqUnique1647();
        String testStr = "aaabbbcc";
        String testStr2 = "bbcebab";
        int ans = test.minDeletions(testStr);
        System.out.println(ans);
    }
}
