import java.lang.reflect.Array;
import java.util.ArrayList;

import DefaultCode.*;


//logn ans -> 3 passes;
public class LCABST235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val >= p.val && root.val <= q.val ||  root.val <= p.val && root.val >= q.val) {
            return root;
        } else if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     ArrayList<Integer> pathtoP = new ArrayList<>();
    //     PathSaver(root, p, pathtoP);
    //     ArrayList<Integer> pathtoQ = new ArrayList<>();
    //     PathSaver(root, q, pathtoQ);
    //     int ans = 0;
    //     while(!pathtoP.isEmpty() && !pathtoQ.isEmpty()) {
    //         int valP = pathtoP.remove(0);
    //         int valQ = pathtoQ.remove(0);

    //         if(valP != valQ) {
    //             return new TreeNode(ans);
    //         } else {
    //             ans = valP;
    //         }
    //     }
        
    //     return new TreeNode(ans);
    // }

    public void PathSaver(TreeNode node, TreeNode target, ArrayList<Integer> path) {
        if(node.val == target.val) {
            path.add(node.val);
        } else {
            if(node.val > target.val){
                path.add(node.val);
                PathSaver(node.left, target, path);
            } else {
                path.add(node.val);
                PathSaver(node.right, target, path);
            }
        }

        return;
    }
}
