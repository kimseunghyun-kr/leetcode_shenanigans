import java.util.HashSet;
import java.util.PriorityQueue;

public class hamNums {
    public long nthHammond(int nNum) {
        PriorityQueue<Long> hammondPq = new PriorityQueue<>();
        HashSet<Long> ExistingHammond = new HashSet<>();
        hammondPq.add((long)1);
        for(int i = 1; i<nNum ; i++){
            long  hammondNum = hammondPq.poll();
            ExistingHammond.add(hammondNum);
            long[] hammondContainer = new long[3];
            hammondContainer[0] = hammondNum*2;
            hammondContainer[1] = hammondNum*3;
            hammondContainer[2] = hammondNum*5;

            for(long Hammonds : hammondContainer) {
                if(ExistingHammond.contains(Hammonds)) {

                } else {
                    hammondPq.add(Hammonds);
                    ExistingHammond.add(Hammonds);
                }
            }

        }
        return hammondPq.poll();
    }

    public static void main(String[] args) {
        hamNums test = new hamNums();
//        test.nthHammond(7);
        for (int i = 0; i<20 ; i++) {
            System.out.println(test.nthHammond(i+1));
        }

    }



}
