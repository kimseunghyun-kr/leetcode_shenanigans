import DefaultCode.*;
class ValBSt98 {
    final long Max = Long.MAX_VALUE;
    final long Min = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) {
            return true;
        }
        return validator(root, null, null);
    }

    public boolean validator (TreeNode node, TreeNode Lpar, TreeNode Rpar) {
        if(node == null) {
            return true;
        } else {
            int val = node.val;
            long left = Lpar == null ? Min : Lpar.val;
            long right = Rpar == null ? Max : Rpar.val;
            if(val <= left || val >= right) {
                return false;
            } else {
                boolean Lsub = validator(node.left, Lpar, node);
                if(Lsub == false) {
                    return Lsub;
                }
                boolean Rsub = validator(node.right, node , Rpar);

                return Lsub && Rsub;
            }
        }
    }
}