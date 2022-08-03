import java.util.TreeMap;
import java.util.Map.Entry;

class MyCalendar729 {
    TreeMap<Integer, Integer> intervalStore;

    public MyCalendar729() {
        intervalStore = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if (intervalStore.size() == 0) {
            intervalStore.put(start, end);
            return true;

        } else {
            if(intervalStore.containsKey(start)) {
                return false;
            }

            Entry<Integer, Integer> GLE = intervalStore.lowerEntry(start); // greatestLowerEntry
            Entry<Integer, Integer> LHE = intervalStore.higherEntry(start); // leastHigherEntry

            boolean canAddLower;
            boolean canAddHigher;
            if (GLE == null) {
                canAddLower = true;
            } else {
                canAddLower = end <= GLE.getKey() || start >= GLE.getValue();
            }

            if(LHE == null) {
                canAddHigher = true;
            } else {
                canAddHigher = end <= LHE.getKey() || start >= LHE.getValue();
            }
            if (canAddHigher && canAddLower) {
                intervalStore.put(start, end);
            }

            return canAddHigher && canAddLower;
        }

    }

    public static void main(String[] args) {
        MyCalendar729 test = new MyCalendar729();
        test.book(33,41);
        test.book(33,42);
    }

}