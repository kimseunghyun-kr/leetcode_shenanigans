import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class  BinTreeLOTraversal102 {
      
      

//  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }





	public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while (!q.isEmpty()) {
            
            List<TreeNode> currLevel = new ArrayList<TreeNode>(q);
            q.clear();
            
            List<Integer> temp = new ArrayList<Integer>();
            for (TreeNode node: currLevel) {
                temp.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            result.add(temp);
        }
        
        return result;
    }
   
 
// 	public List<List<Integer>> levelOrder(TreeNode root) {
        
    

// 		List<TreeNode> queue = new ArrayList<>();
// 		List<List<Integer>> ans = new ArrayList<>();
        
//         if(root == null) {
//             return ans;
//         }
// 		queue.add(root);
			
// 		return recurser(queue, 0, ans);
// 	}

// 	public List<List<Integer>> recurser (List<TreeNode> Q , int level, List<List<Integer>> ans) {
		
// 		if(Q.size() == 0) {
// 		    return ans;
// 		}
// 		List<Integer> newQ = new ArrayList<Integer>();
// 		List<TreeNode> nextQ = new ArrayList<>();

// 		while(Q.size() != 0 && Q != null) {
// 			TreeNode tgt = Q.remove(0);
// 			newQ.add(tgt.val);
// 			if(tgt.left != null) {
// 				nextQ.add(tgt.left);
// 			}

// 			if(tgt.right != null) {
// 				nextQ.add(tgt.right);
// 			}
// 		}
		
		
// 		ans.add(level,newQ);
// 		return recurser(nextQ, level+1, ans);

	

// 	}
}

