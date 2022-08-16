import java.util.HashMap;

class FUCS387 {
    public int firstUniqChar(String s) {
        int[] Map = new int[26];

        for(int i = 0 ; i < s.length() ; i++) {
            Map[s.charAt(i)-97] = Map[s.charAt(i)-97] + 1;
        }

        for(int i = 0 ; i < s.length() ; i++) {
            if(Map[s.charAt(i)-97] == 1) {
                return i;
            }
        }

        return -1;




        // HashMap<Character, Integer> occurence = new HashMap<>();
        // for(int i = 0 ; i < s.length() ; i++) {
        //     int get = occurence.getOrDefault(s.charAt(i), -1);
        //     if(get == -1) {
        //         occurence.put(s.charAt(i),1);
        //     } else {
        //         occurence.replace(s.charAt(i), get, get+1);
        //     }
        // }

        // for(int i = 0 ; i < s.length() ; i++) {
        //     if(occurence.get(s.charAt(i)) == 1) {
        //         return i;
        //     }
        // }

        // return -1;
    }
}