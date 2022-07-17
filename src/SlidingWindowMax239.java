import java.util.LinkedList;

public class SlidingWindowMax239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k + 1];
        LinkedList<Integer> deque = new LinkedList<>();
        int maxIdx = 0;

        for(int i = 0 ; i < nums.length ; i++) {


            if(!deque.isEmpty() && deque.peekFirst() <= i-k){
                int temp = ans[deque.peekFirst()];
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);

            if(i >= k-1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        SlidingWindowMax239 test = new SlidingWindowMax239();
        int[] tester = {1,3,-1,-3,5,3,6,7};
        int[] ans = test.maxSlidingWindow(tester, 3);
        for(int k : ans) {
            System.out.print(k + ",");
        }
    }
}
