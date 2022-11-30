import java.util.Arrays;

public class UniqOccur {
    public static boolean uniqueOccurrences(int[] arr) {
        int[] hash = new int[2001];
        for(int i = 0 ; i < arr.length ; i++) {
            hash[arr[i] + 1000] += 1;
        }
        Arrays.sort(hash);

        for(int i = hash.length-1 ; i >= 0 ; i--) {
            if(hash[i] == 0 ) {
                return true;
            } else {
                if(hash[i] == hash[i-1]) {
                    return false;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        boolean test = uniqueOccurrences(new int[] {1,2,1,1,3,3});
        System.out.println(test);
    }
}
