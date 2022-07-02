import java.util.Arrays;
import java.util.PriorityQueue;

public class ConsTargetArrMultSum1354 {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> store = new PriorityQueue<>((a,b)->b-a);
        int sum = 0;

        for(int i = 0; i < target.length ; i++) {
            store.add(target[i]);
            sum +=target[i];
        }

        if(target.length == 1) {
            return true;
        } else {
            while (store.peek() != 1) {
                int currLargest = store.poll();
                sum -= currLargest;
                if(sum == 1) {
                    return true;
                }

//                int remainder = currLargest - sum;

//                from discussion
                int remainder = currLargest % sum;

                if(remainder == 0 || remainder == currLargest) {
                    return false;
                } else {
                    sum += remainder;
                    store.add(remainder);
                }

            }
            return true;
        }
    }
}
