package leetcode;

public class The5 {
    /**
     * dp[i][j] 表示字符 s[i,j] 是否是回文串：
     * 由于 dp[i][j] 需要 dp[i + 1][j - 1], 因此从后向前，先计算 i == n - 2 的情况
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;
        int start = 0, end = 0;

        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = true;
        }
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = j == i + 1 || dp[i + 1][j - 1];
                    if (dp[i][j] && (end - start) < (j - i)) {
                        start = i;
                        end   = j;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
