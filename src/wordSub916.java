import java.util.ArrayList;
import java.util.List;

public class wordSub916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxCharNumStore = new int[26];
        List<String> ans = new ArrayList<>();

        //all max number of words in maxCharNumStore
        for(String i : words2) {
            int[] currWordMap = new int[26];
            for(int a = 0 ; a < i.length(); a++) {
                int curr = i.charAt(a) - 97;
                currWordMap[curr]++;
            }

            for(int j = 0 ; j < currWordMap.length; j++) {
                maxCharNumStore[j] = Math.max(maxCharNumStore[j],currWordMap[j]);
            }
        }

//        compared with words1 arr
        for(String i : words1) {
            int[] currWordMap = new int[26];
            for(int a = 0 ; a < i.length(); a++) {
                int curr = i.charAt(a) - 97;
                currWordMap[curr]++;
            }
            boolean isUni = true;
            for(int j = 0 ; j < currWordMap.length; j++) {
                isUni = isUni && currWordMap[j]>=maxCharNumStore[j];
            }

            if(isUni) {
                ans.add(i);
            }
        }

        return ans;

    }
}
