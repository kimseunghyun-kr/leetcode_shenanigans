

import java.util.HashMap;

public class ValidAna242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> charStore = new HashMap<>();
        int i = 0;
        for(int j = 0; j < s.length() ; j++) {
            i++;
            Character curr = s.charAt(j);
            if(charStore.containsKey(curr)) {
                int num = charStore.get(curr);
                charStore.put(curr, num+1);
            } else {
                charStore.put(curr,1);
            }
        }

        if(i != t.length()) {
            return false;
        }

        for(int j = 0 ; j < t.length() ; j++) {
            char curr = t.charAt(j);
            int num = charStore.getOrDefault(curr, -1);
            if(num <= 0) {
                return false;
            } else {
                if(num == 1) {
                    charStore.remove(curr);
                } else {
                    charStore.replace(curr, num, num-1);
                }
            }
        }

        if(charStore.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }


    // public boolean isAnagram(String s, String t) {
    //     int[] alphabet = new int[26];
    //     for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
    //     for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
    //     for (int i : alphabet) if (i != 0) return false;
    //     return true;
    // }
}
