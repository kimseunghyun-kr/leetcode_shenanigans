
//a dfs approach
import DefaultCode.*;

class LCATN2336 {
// alternative
    /*     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //base case
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //result
        if(left == null) {
            return right;
        }
        else if(right == null) {
            return left;
        }
        else { //both left and right are not null, we found our result
            return root;
        }
    }
     */
    TreeNode ansNode = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ansNode;

    }

    boolean isPmet = false;
    boolean isQmet = false;

    public boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if(node == null) {
            return false;
        } else {
            
            boolean isElemLeft = dfs(node.left,p,q);
            boolean isElemRight = dfs(node.right,p,q);

            if(node.val == p.val || node.val == q.val) {
                if(isElemLeft || isElemRight) {
                    ansNode = node;
                }
                return true;
            }

            if(isElemLeft && isElemRight) {
                ansNode = node;
            }

            return isElemLeft || isElemRight;
        }

       
    }
}