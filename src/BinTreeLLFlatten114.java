import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import DefaultCode.*;

class BinTreeLLFlatten114 {


    // public void flatten(TreeNode root) {
    //     TreeNode curr = root;

    //     if(curr == null) {
    //         return;
    //     }

    //     TreeNode OGLeft = curr.left;
    //     TreeNode OGRight = curr.right;

    //     curr.left = null;
    //     flatten(OGLeft);
    //     curr.right = OGLeft;

    //     while(curr.right != null) {
    //         curr = curr.right;
    //     }

    //     flatten(OGRight);
        
    //     curr.left = null;
    //     curr.right = OGRight;

        
    // }


ArrayList<TreeNode> ans;


    public void flatten(TreeNode root) {
        ans = new ArrayList<>();
        preOrder(root);
        for(int i = 0 ; i < ans.size() ; i++) {
            if(i ==0 ) {
                continue;
            } else {
                root.left= null;
                root.right = ans.get(i);
                root = root.right;
            }
        }
  

    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        } else {
            ans.add(new TreeNode(root.val));
            preOrder(root.left);
            preOrder(root.right);

        }
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        TreeNode right = new TreeNode(5, null, new TreeNode(6));
        TreeNode test = new TreeNode(1, left, right);

        BinTreeLLFlatten114 tester = new BinTreeLLFlatten114();
        tester.flatten(test);
        int i = 1;
        while(i<=6) {
            System.out.println(test.val);
            test = test.right;
            i++;
        }
    }
}