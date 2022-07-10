import java.util.*;

public class LongestStringChain {
    HashMap<Integer, ArrayList<String>> stringStore = new HashMap<>();
    String[] globalWords = new String[0];


    public int tabulatedLongest (String[] words) {
        Arrays.sort(words, (String a, String b) -> a.length() - b.length());
        HashMap<String, Integer> dpMap = new HashMap<>();
        int maxPath = 1;
        for(String s : words) {
            StringBuilder sb = new StringBuilder(s);
            int currMax = 1;
            for(int i = 0 ; i < s.length() ; i++) {
                sb.deleteCharAt(i);
                String deleted = sb.toString();
                currMax = Math.max(currMax, dpMap.getOrDefault(deleted , 0)+1);
                sb.insert(i, s.charAt(i));
            }
            dpMap.put(sb.toString() , currMax);
            maxPath = Math.max(maxPath, currMax);

        }

                return maxPath;

    }
    public int longestStrChain(String[] words) {
//        Arrays.sort(months,
//            (String a, String b) -> a.length() - b.length());

        //sort according to len
        Arrays.sort(words, Comparator.comparingInt(String::length));
        globalWords = words;


        //insert word to hashmap
        for(String s : words) {
            stringStore.putIfAbsent(s.length(), new ArrayList<String>());
            stringStore.get(s.length()).add(s);
        }
        int result = 0;
        for(String s : words) {
            result = Math.max(result,pODfs(s));
        }

//      tabulated








        return result;
    }

    public int pODfs(String word) {
        if(word.length() == globalWords[globalWords.length-1].length()) {
            return 1;
        } else {
            int currWordLen = word.length();
            List<String> someList = stringStore.get(currWordLen+1);
            if(someList == null) {
                return 1;
            }
            int currMax = 1;
            for(String str : someList) {
                if(isOneCharDiff(word, str)) {
                    currMax = Math.max(currMax,1 + pODfs(str));
                }
            }
            return currMax;
        }
    }

    public boolean isOneCharDiff(String base, String toComp) {
        StringBuilder toCompSb = new StringBuilder(toComp);
        for(int i = 0 ; i < toComp.length() ; i++) {
            if(toCompSb.deleteCharAt(i).toString().equals(base)) {
                return true;
            }
            toCompSb.insert(i, toComp.charAt(i));
        }
        return false;
    }


    public static void main(String[] args) {
        LongestStringChain test = new LongestStringChain();
        String[] testArr = {"a","b","ab","bac"};
        int ans = test.tabulatedLongest(testArr);
        System.out.println(ans);
    }
}
