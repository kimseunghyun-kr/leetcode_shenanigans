import DefaultCode.*;
public class SAtoBST108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = buildTree(nums, 0, nums.length-1);
        return root;
    }

    public TreeNode buildTree(int[] nums, int left, int right) {
        if(right < left) {
            return null;
        } else {
            int mid = (left + right)/2;
            TreeNode newNode = new TreeNode(nums[mid], buildTree(nums, left, mid-1), buildTree(nums, mid+1, right));
            return newNode;
        }
        
    }    
    
}
