package toRedo;

public class RSQM307 {

//    general concept of linking to heap was difficult -> worthy of redoing as it test concept of segment tree

    public class NumArray {
        int n;
        int[] tree;

        public NumArray(int[] nums) {
            n = nums.length;
            if(nums.length > 0) {
                tree = new int[n*2];
                buildTree(tree, nums);
            }

        }


        //segment tree array form; -> like a heap
        public void buildTree(int[] tree , int[] nums) {
            for (int i = n, j = 0;  i < 2 * n; i++,  j++) {
                tree[i] = nums[j];
            }

            for(int i = n-1; i > 0 ; i--) {
                tree[i] = tree[i*2] + tree[i*2+1];
            }
        }

        public void update(int index, int val) {
            int treeIdx = index + n;
            tree[treeIdx] = val;
            while(treeIdx > 0) {
                treeIdx = treeIdx/2;
                tree[treeIdx] = tree[treeIdx*2] + tree[treeIdx*2+1];
            }

        }


//redo this part
        public int sumRange(int left, int right) {
            // get leaf with value 'l'
            left += n;
            // get leaf with value 'r'
            right += n;
            int sum = 0;
            while (left <= right) {
                if ((left % 2) == 1) {
                    sum += tree[left];
                    left++;
                }
                if ((right % 2) == 0) {
                    sum += tree[right];
                    right--;
                }
                left /= 2;
                right /= 2;
            }
            return sum;
        }


    }
    
}
