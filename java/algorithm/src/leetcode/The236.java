package leetcode;

import leetcode.util.TreeNode;

public class The236 {
    TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        return ans;
    }


    /**
     * 判断 root 树下有无 q 或者 p 节点 （含qp)
     */
    private boolean search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean left = search(root.left, p, q);
        boolean right = search(root.right, p, q);
        if ((left && right) || ((left || right) && (root.val == p.val || root.val == q.val))) {
            this.ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }
}
