package leetcode;

import leetcode.util.TreeNode;

public class The222 {
    private String rcd = null;

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        helper(root, new StringBuilder("1"), ' ');
        return Integer.parseInt(rcd, 2);
    }

    private void helper(TreeNode root, StringBuilder sb, char c) {
        if (c != ' ') sb.append(c);
        if (root.left == null && root.right == null) {
            rcd = maxString(rcd, sb.toString());
        }
        if (root.left != null) {
            helper(root.left, sb, '0');
        }

        if (root.right != null) {
            helper(root.right, sb, '1');
        }
        if (c != ' ') sb.deleteCharAt(sb.length() - 1);
    }

    private String maxString(String s1, String s2) {
        if (s1 == null) return s2;
        if (s2 == null) return s1;

        if (s1.length() != s2.length()) {
            return s1.length() > s2.length() ? s1 : s2;
        }
        for (int i = 0; i < s1.length(); ++i) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 > c2) {
                return s1;
            } else if (c1 < c2) {
                return s2;
            }
        }
        return s1;
    }
}
