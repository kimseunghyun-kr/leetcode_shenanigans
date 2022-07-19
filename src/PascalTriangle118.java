import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class PascalTriangle118 {
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> ans = new LinkedList<List<Integer>>();
        for(int i = 0 ; i < numRows ; i++) {
            List<Integer> component = new ArrayList<>();
            List<Integer> prevComponent = new ArrayList<>();
            if(i!= 0) {
                prevComponent= ans.getLast();
            }
            
            for(int j = 0 ; j <= i ; j++) {
                if(j == 0 || j == i) {
                    component.add(1);
                } else {
                    component.add(prevComponent.get(j-1) + prevComponent.get(j));
                }
            }

            ans.addLast(component);

        }
        return ans;

    }

    public static void main(String[] args) {
        PascalTriangle118 test = new PascalTriangle118();
        List<List<Integer>> ans = test.generate(5);
        System.out.println(ans);

    }
    
}