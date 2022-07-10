public class BinTreeCam {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        int covered;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public int minCameraCover(TreeNode root) {
        this.root = root;
        count = 0;
        DFSFill(root);
        return count;
    }

    public void TopDownFill(TreeNode node, int ParentCamCover, int LHCover) {
        //logic is difficult to implement

        //if parent is cam -> lr fill/unfill | lfill runfill | lunfill rfill all possible
        //if parent is covered -> lr fill/unfill | lfill runfill | lunfill rfill all possible
        //if parent is uncovered -> l fill r unfill | lunfill r fill | lrfill

//        difficult to set


    }

    int count = 0;
    TreeNode root = null;
    public int DFSFill(TreeNode node) {
        //-1 unfill 0 monitored 1 filled

        if(node == null) {
            return 0;
        } else {
//            DFS
            int left = DFSFill(node.left);
            int right = DFSFill(node.right);

            if( left == -1 || right == -1) { // either of the 2 are not monitored
                count++;
                return 1;

            } else if (left == 1 || right == 1 ){ //either of the 2 are cams with
                return 0;

            } else if(left == 0 && right == 0) { //both are monitored;
                if(node == root) {
                    count ++;
                    return 1;
                }
                return -1;
            } else {
                System.out.println("error");
                return -100;
            }
        }
    }

//    public int minCameraCover(TreeNode root) {
//        int rootCovered = 1 + recurser(root.left, 1) + recurser(root.right,1);
//        int rootNocovered = recurser(root.left,-1) + recurser(root.right,-1);
//        return Math.min(rootCovered, rootNocovered);
//    }


//    public int recurser(TreeNode node, int ParentCamCover){
//        if(node == null) {
//            return 0;
//        }
////         parent is: parentCamCover = -1 -> uncovered , parentCamCover = 0 -> covered , parentCamcover = 1 -> iscam
//        if(ParentCamCover == 1) {
//            if(isLeaf(node)){
//                return 0;
//            } else {
//                return Math.min(1+recurser(node.left, 1) + recurser(node.right, 1), recurser(node.left, 0) + recurser(node.right, 0));
//            }
//        } else if (ParentCamCover == 0) {
//            if (isLeaf(node)) { //currnode is uncovered
//                return 1;
//            } else {
//                //covered vs uncovered
//                return Math.min(1+recurser(node.left, 1) + recurser(node.right, 1), recurser(node.left, -1) + recurser(node.right, -1));
//            }
//        } else {
//            if (isLeaf(node)) {
//                return 1;
//            }
//            //parebtCamCover == -1 -> parent is uncovered, need to add cam in currnode
//            int lsNocover = recurser(node.left)
//            return 1+ recurser(node.left,1) + recurser(node.right,1);
//        }
//    }
}