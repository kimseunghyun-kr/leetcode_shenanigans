import java.util.*;

public class BinTreeConsfromInPre105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //initially done without the hashmap , iterated along subarray present, with pointers start, end
    // not included as provided solution is better
    // modified and referred to leetcode solns, courtesy of leetcode.

    /*previously - > TLE */
    // int preorderIndex;
    // private TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
    //     // if there are no elements to construct the tree
    //     if (left > right) return null;

    //     // select the preorder_index element as the root and increment it
    //     int idx = left;
        
    //     while(inorder[idx] != preorder[preorderIndex] && idx < right) {
    //         idx++;
    //     }
            
    //     int rootValue = preorder[preorderIndex++];
    //     TreeNode root = new TreeNode(rootValue);

    //     // build left and right subtree
    //     // excluding inorderIndexMap[rootValue] element because it's the root
    //     root.left = helper(preorder, inorder, left, idx - 1);
    //     root.right = helper(preorder,inorder, idx + 1, right);
    //     return root;
    // }
 

    //hashmap Integration;
    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        // build a hashmap to store value -> its index relations
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // if there are no elements to construct the tree
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);
        return root;
    }


    // idea of solution was that the inorder + preorder traversals put together will create an array st
    // if number is surrounded by another number, i.e. 1221 -> 1 is left parent of 2; if there is an insert
    // such that 122331, then 3 is right child of 1.
    // did not work for test case [3,2,1] and [1,2,3] -> forms 1 3 2 2 3 1 -> not equal to the ans 1 2 null 3
//    failed code
   
   
    // LinkedList<Integer> inPreOrder;

    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     inPreOrder = new LinkedList<>();
    //     for (int i = 0; i < preorder.length * 2; i++) {
    //         if (i % 2 == 1) {
    //             inPreOrder.addLast(inorder[i / 2]);
    //         } else {
    //             inPreOrder.addLast(preorder[i / 2]);
    //         }
    //     }

    //     TreeNode root = new TreeNode(preorder[0]);
        
    //     TreeNode ans = TreeMaker(root, true);
    //     int ansval = ans.val;
    //     int ansleftVal = ans.left.val;

    //     while(!inPreOrder.isEmpty()) {
    //         TreeNode rTreeRoot = new TreeNode(inPreOrder.peekFirst());
    //         ans.right = TreeMaker(rTreeRoot, true);
    //         ans = ans.right;
    //     }

    //     int ansval2 = ans.val;

    //     return root;

    // }

    // public TreeNode TreeMaker(TreeNode root, boolean IsFirst) {
    //     LinkedList<Integer> stack = new LinkedList<>();
    //     TreeNode prevPop = null;
    //     boolean isPrevPop = false;
    //     boolean isFirst = IsFirst;

    //     while (!inPreOrder.isEmpty()) {

    //         int currNum = inPreOrder.pollFirst();
    //         if(isFirst && stack.size() == 1 && stack.peekLast() == currNum ) {
    //             if(prevPop != null) {
    //                 root.left = prevPop;
    //             }
    //             return root;
    //         }
    //         if (isPrevPop) {
    //             // pop
    //             if (!stack.isEmpty() && stack.peekLast() == currNum) {
    //                 // is left child
    //                 stack.pollLast();
    //                 TreeNode curr = new TreeNode(currNum);
    //                 curr.left = prevPop;
    //                 prevPop = curr;
    //             } else {
    //                 // is right child;
    //                 stack.addLast(currNum);
    //                 TreeNode curr = new TreeNode(currNum);
    //                 prevPop.right = TreeMaker(curr, true);
    //                 isPrevPop = false;
    //             }
    //         } else {
    //             // ins
    //             if (!stack.isEmpty() && stack.peekLast() == currNum) {
    //                 stack.pollLast();
    //                 prevPop = new TreeNode(currNum);
    //                 isPrevPop = true;
    //             } else {
    //                 stack.addLast(currNum);
    //             }
    //         }
    //     }

    //     return root;

    // }

    public static void main(String[] args) {
        BinTreeConsfromInPre105 tester = new BinTreeConsfromInPre105();
        int[] inorder = {3,2,1};
        int[] preorder = {1,2,3};
        TreeNode ans = tester.buildTree(preorder, inorder);
        System.out.println(ans.val);

    }
}