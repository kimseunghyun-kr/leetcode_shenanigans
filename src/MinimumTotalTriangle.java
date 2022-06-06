import java.util.ArrayList;
import java.util.List;

public class MinimumTotalTriangle {

//    minimum of the entire triangle by height
//    public int minimumTotalperHeight(List<List<Integer>> triangle) {
//        if(triangle.size() == 1) {
//            return triangle.get(0).get(0);
//        } else {
//            List<List<Integer>> nminus1Triangle = triangle.subList(0, triangle.size()-1);
//            int minimumPrev = minimumTotalperHeight(nminus1Triangle);
//            List<Integer> currList = triangle.get(triangle.size()-1);
//            int result = Integer.MAX_VALUE;
//            for(int k : currList) {
//                result = Math.min(result, k + minimumPrev);
//            }
//
//            return result;
//        }
//
//    }

//    internal workings
//    merely modifying above did not work as there is no guarantee that Math.min(prevList + currNum) ==> smallest in the currList;
//    max result in prevList may actl be the smallest when including the current number in currList due to the number in currList being the smallest;
//    necessitates a storage of all possible min combi of each position in the currList
//    hence the usage of a list to store the possibilities -> dp tabulation
//    work from bottom up.
//    time complexity : n/2 + n + n/2
//    reason : n/2 -> last tree probably n/2 or 1/x* n  where n is the total numbers present in the list
//    n -> each number is compared once.
//    total O(n)_ ??
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = triangle.get(0).get(0);
        int[] tableOfMins = new int[triangle.get(triangle.size()-1).size()];
        tableOfMins[0] = min;

        if(triangle.size() == 1) {
            return min;
        } else {
            for(int k = 1 ; k < tableOfMins.length ; k++){
                tableOfMins[k] = Integer.MAX_VALUE;
            }


            for (int i = 1; i < triangle.size() ; i++) {
                for (int j = triangle.get(i).size() - 1; j >= 0 ; j--) {
                    int currNum = triangle.get(i).get(j);

                    if(j-1 < 0) {
                        tableOfMins[j] = tableOfMins[j] + currNum;
                    } else if(tableOfMins[j] == Integer.MAX_VALUE) {
                        tableOfMins[j] = tableOfMins[j-1] + currNum;
                    } else {
                        tableOfMins[j] = Math.min(tableOfMins[j] + currNum, tableOfMins[j - 1] + currNum);
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int p : tableOfMins) {
            result = Math.min(p,result);
        }

        return result;


    }


    public static void main(String[] args) {
        MinimumTotalTriangle test = new MinimumTotalTriangle();
        ArrayList<List<Integer>> tri = new ArrayList<>();
        ArrayList<Integer> levelOne = new ArrayList<>();
        ArrayList<Integer> levelTwo = new ArrayList<>();
        ArrayList<Integer> levelThree = new ArrayList<>();

        levelOne.add(1);
        levelTwo.add(2);
        levelTwo.add(3);
        levelThree.add(4);
        levelThree.add(5);
        levelThree.add(6);
        tri.add(levelOne);
        tri.add(levelTwo);
        tri.add(levelThree);


        test.minimumTotal(tri);
        System.out.println(test.minimumTotal(tri));
    }

}
