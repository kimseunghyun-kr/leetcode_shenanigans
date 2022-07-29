import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.xml.sax.HandlerBase;

class FNRPattern890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String curr = words[i];
            int[] mappingStore = new int[26]; // surjective
            boolean[] isPresentStore = new boolean[26]; // injective
            boolean toAdd = true;

            for (int j = 0; j < curr.length(); j++) {
                int currLtoAscii = curr.charAt(j);
                int patterntoAscii = pattern.charAt(j) - 97;
                if (mappingStore[patterntoAscii] == 0) {
                    if (isPresentStore[currLtoAscii - 97]) {
                        toAdd = false;
                        break;
                    } else {
                        mappingStore[patterntoAscii] = currLtoAscii;
                        isPresentStore[currLtoAscii - 97] = true;
                    }
                } else {
                    if (mappingStore[patterntoAscii] != currLtoAscii) {
                        toAdd = false;
                        break;
                    }
                }
            }

            if (toAdd) {
                ans.add(words[i]);
            }

        }

        return ans;
    }
}