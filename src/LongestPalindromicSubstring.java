import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestPalindromicSubstring {

    //2 pointer method -> faster

    public String longestPalindrome2point(String s) {
        int sI = 0, eI = 0;
        for (int i = 0; i < s.length(); i++) {
            int l1 = getPalindromeLength(s, i, i); //find max for 1-base palind
            int l2 = getPalindromeLength(s, i, i + 1); //find max for 2-base palind;
            int len = Math.max(l1, l2);
            if (len > eI - sI) {
                sI = i - (len - 1) / 2;
                eI = i + len / 2;
            }
        }
        return s.substring(sI, eI + 1);
    }

    private static int getPalindromeLength(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }



//some dp method
    public class Pair {
        int startIdx;
        int endIdx;

        public Pair(int startIdx, int endIdx) {
            this.endIdx = endIdx;
            this.startIdx = startIdx;
        }

        public boolean isDefault() {
            return this.startIdx == -1 && this.endIdx == -1;
        }
    }

    public String longestPalindrome(String s) {
        Pair longestSubStringPair = new Pair(0,1);
        int longestSubStringLen = 1;
        boolean[][] booleanTable = new boolean[s.length()][s.length()];

        for(int len = 0 ; len < s.length() ; len++) { //length of the str
            for(int j = 0; j+len < s.length() ; j++) { //starting position
                if(len == 0) {
                    booleanTable[j][j+len] = true;
                } else if (len == 1) {
                    booleanTable[j][j + len] = s.charAt(j) == s.charAt(j + len);
                    if(booleanTable[j][j+len]) {
                        longestSubStringLen = len+1;
                        longestSubStringPair = new Pair(j,j+len+1);
                    }
                } else {
                    booleanTable[j][j+len] = s.charAt(j) == s.charAt(j+len) && booleanTable[j+1][j+len-1];
                    if(booleanTable[j][j+len]) {
                        longestSubStringLen = len+1;
                        longestSubStringPair = new Pair(j,j+len+1);
                    }
                }
            }
        }
        return s.substring(longestSubStringPair.startIdx, longestSubStringPair.endIdx);
    }





//    HashMap<Integer, List<Pair>> palinBases = new HashMap<>();
//    Pair greatestPalin = new Pair(0,0);
//    int greatestPalinLength = 1;
//
//
//
//    public String longestPalindrome(String s) {
//        palinBaseFinder(s);
//        StringBuilder sb = new StringBuilder(s);
//        for(Pair baseOnePalins : palinBases.get(1)) {
//            if(baseOnePalins.startIdx == 0 || baseOnePalins.startIdx == s.length()) {
//            } else {
//                if(sb.charAt(baseOnePalins.startIdx+1) == sb.charAt(baseOnePalins.startIdx -1)) {
//
//                }
//            }
//        }
//
//
//
//
//
//    }
//
//    public void palinBaseFinder(String s) {
//        palinBases.put(1, new ArrayList<Pair>());
//        palinBases.put(2, new ArrayList<Pair>());
//        for(int i = 0 ;  i < s.length() ; i++) {
//            palinBases.get(1).add(new Pair(i,i));
//            if(i+1 < s.length()) {
//                if(s.charAt(i) == s.charAt(i+1)) {
//                    palinBases.get(2).add(new Pair(i,i+1));
//                }
//            }
//        }
//    }

    public int isPalindrome(String s) {
        if (s.length() == 1) {
            return 1;
        } else if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? 2 : 0;
        } else {
            if(s.charAt(0) == s.charAt(s.length()-1)) {
                StringBuilder sb = new StringBuilder(s);
                String newString = sb.substring(1, sb.length() - 1).toString();
                return 2 + isPalindrome(newString);
            }
            else {
                return 0;
            }
        }
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        int ans = test.isPalindrome("abbas");
        System.out.println(ans);
    }
}
