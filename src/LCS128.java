// in O(n) time and space complexity


import java.util.HashMap;
import java.util.HashSet;
public class LCS128
{
    // lets do key , parent
     HashMap<Integer, Integer> arrNumLengthMap = new HashMap<>();
     HashSet<Integer> isVisited = new HashSet<>();
    
    public int longestConsecutive(int[] nums) {
        result = 0;
        
        for(int i : nums) {
            arrNumLengthMap.put(i,1);
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(!isVisited.contains(nums[i])) {
                find(nums[i]);
            }
        }
        
        return result;
        
       
    }
    
    int result = 0;
    
    public int find(int i) {
        isVisited.add(i);
        
        if(!isVisited.contains(i-1)) {
            
            if(arrNumLengthMap.containsKey(i-1)) {
                
                int nextSize = find(i-1) + arrNumLengthMap.get(i);
                arrNumLengthMap.put(i,nextSize);
                result = Math.max(result, nextSize);
                return nextSize;
                
            } else {
                result = Math.max(result, arrNumLengthMap.get(i));
                return arrNumLengthMap.get(i);
            }
            
        } else {
            int newSize = arrNumLengthMap.get(i-1) + arrNumLengthMap.get(i);
            arrNumLengthMap.put(i,newSize);
            result = Math.max(result, newSize);
            return newSize;
        }
        
    }
    
 
    
	public static void main(String[] args) {
		LCS128 test = new LCS128();
		int[] testArr = {0};
		int ans = test.longestConsecutive(testArr);
		System.out.println(ans);
	}
	
// 	[100,4,200,1,3,2]
}
