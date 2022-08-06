public class PoorPigs458 {

    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int numTests = minutesToTest / minutesToDie;

        int i = 0;

        while(Math.pow(numTests+1, i) < buckets) {
            i++;
        }

        return i;

    }

    public static void main(String[] args) {
        PoorPigs458 pigs = new PoorPigs458();
        int ans = pigs.poorPigs(4,15,15);
        System.out.println();
    }
}
