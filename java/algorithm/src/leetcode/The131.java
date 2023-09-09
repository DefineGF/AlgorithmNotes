package leetcode;

import java.util.LinkedList;
import java.util.List;

public class The131 {
    List<List<String>> result = new LinkedList<>();

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }

        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = j == i + 1 || dp[i + 1][j - 1];
                }
            }
        }
        // 截取字符串
        helper(dp, s, 0, new LinkedList<>());
        return result;
    }


    /**
     * 根据 dp 记录，回溯获取结果
     */
    void helper (boolean[][] dp, String s, int i, LinkedList<String> temp) {
        if (i >= s.length()) {
            List<String> copy = new LinkedList<>(temp);
            result.add(copy);
            return;
        }
        for (int k = i; k < s.length(); ++k) {
            if (dp[i][k]) {
                temp.add(s.substring(i, k + 1));
                helper(dp, s, k + 1, temp);
                temp.removeLast();
            }
        }
    }
}
