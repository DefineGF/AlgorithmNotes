package leetcode;

import leetcode.util.TreeNode;

public class The129 {
    private int ans = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int temp) {
        temp = temp * 10 + root.val;
        if (root.left == null && root.right == null) {
            ans += temp;
            return;
        }

        if (root.left != null) {
            helper(root.left, temp);
        }

        if (root.right != null) {
            helper(root.right, temp);
        }
    }
}
