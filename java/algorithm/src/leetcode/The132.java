package leetcode;

import java.util.Arrays;

public class The132 {

    public static void main(String[] args) {
        String input = "ababababababababababababcbabababababababababababa";
        System.out.println(input.length());
        int res = new The132().minCut(input);
        System.out.println(res);
    }

    public int minCut(String s) {
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

        // 第二重动态规划
        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (dp[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (dp[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }
}
