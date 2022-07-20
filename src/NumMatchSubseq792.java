import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;;

class NumMatchSubseq792 {
    HashMap<Character, List<String>> trie = new HashMap<>();
    HashMap<Character, Integer> wordIdxStore = new HashMap<>();

    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        final int slen = s.length();
        for (int i = 0; i < slen; i++) {
            if (!trie.containsKey(s.charAt(i))) {
                trie.put(s.charAt(i), new ArrayList<String>());
                if (!wordIdxStore.containsKey(s.charAt(i))) {
                    wordIdxStore.put(s.charAt(i), i);
                }
            }
        }

        for (String word : words) {
            char firstLetter = word.charAt(0);
            if (trie.containsKey(firstLetter) && word.length() <= slen - wordIdxStore.get(firstLetter)) {
                List<String> temp = trie.get(firstLetter);
                temp.add(word);
            }
        }

        for (int i = 0; i < slen; i++) {
            List<String> validWords = trie.get(s.charAt(i));
            int listSize = validWords.size();
            for (int j = 0; j < listSize; j++) {
                String toComp = validWords.get(0);
                validWords.remove(0);
                if(toComp.length() == 1) {
                    result ++;
                } else {
                    String firstLetterGone = toComp.substring(1);
                    if(trie.containsKey(firstLetterGone.charAt(0))) {
                        List<String> temp2 = trie.get(firstLetterGone.charAt(0));
                        temp2.add(firstLetterGone);
                    }
                }
            }

        }

        return result;
    }

    public boolean isSubstring(String s1, String s2) {
        int wordLen = s2.length();
        int index = 0;
        int wordIdx = 0;
        while (index <= s1.length()) {
            if (wordIdx == s2.length()) {
                return true;
            } else if (index == s1.length()) {
                return false;
            } else if (s1.length() - index - 1 < wordLen - wordIdx - 1) {
                return false;
            } else {
                char a = s2.charAt(wordIdx);
                char b = s1.charAt(index);
                if (a == b) {
                    index++;
                    wordIdx++;
                } else {
                    index++;
                }
            }
        }

        return false;
    }
    
    

    // TLEed
    // public int legacyCode(String s, String[] words) {
    //     int result = 0;
    //     final int slen = s.length();
    //     for (String word : words) {
    //         int wordLen = word.length();
    //         int index = 0;
    //         int wordIdx = 0;
    //         while (index <= s.length()) {
    //             if (wordIdx == word.length()) {
    //                 result++;
    //                 break;
    //             } else if (index == s.length()) {
    //                 break;
    //             } else if (slen - index - 1 < wordLen - wordIdx - 1) {
    //                 break;
    //             } else {
    //                 char a = word.charAt(wordIdx);
    //                 char b = s.charAt(index);
    //                 if (a == b) {
    //                     index++;
    //                     wordIdx++;
    //                 } else {
    //                     index++;
    //                 }
    //             }
    //         }
    //     }
    //     return result;
    // }

    public static void main(String[] args) {
        NumMatchSubseq792 test = new NumMatchSubseq792();
        int ans = test.numMatchingSubseq("btovxbkumc", new String[] {"btovxbkumc","to","zueoxxxjme","yjkclbkbtl"});
        System.out.println(ans);
    }
}


// "btovxbkumc"
// ["btovxbku","to","zueoxxxjme","yjkclbkbtl"]