import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> repeatStore = new HashMap<>();

        for (String word : words) {
            int numTemp = repeatStore.getOrDefault(word, -1);
            if (numTemp == -1) {
                repeatStore.put(word, 1);
            } else {
                repeatStore.replace(word, numTemp, numTemp + 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        final int WORDLEN = words[0].length();
        final int subStringLen =  (WORDLEN * words.length);

        for(int i = 0 ; i < s.length() - subStringLen + 1 ; i++) {
            HashMap<String, Integer> deepCopy = new HashMap<>(repeatStore);
            String sub = s.substring(i, i + subStringLen);
            for(int j = 0 ; j < subStringLen ; j += WORDLEN) {
                String wordBlock = sub.substring(j, j+WORDLEN);
                int val = deepCopy.getOrDefault(wordBlock, -1);
                if(val == -1) {
                    break;
                } else {
                    if(val == 1) {
                        deepCopy.remove(wordBlock);
                    } else {
                        deepCopy.replace(wordBlock, val, val-1);
                    }
                }
            }
            if (deepCopy.isEmpty()) {
                ans.add(i);
            }
        }

    return ans;

    }

    public static void main(String[] args) {
        SubstringConcatAllWords test = new SubstringConcatAllWords();
        List<Integer> ans = test.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"});
        System.out.println(ans);
    }
}

//"wordgoodgoodgoodbestword"
