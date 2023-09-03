package leetcode;

import java.util.Arrays;

public class The300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int len = 1;
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; ++i) {
            int target = nums[i];
            if (target > dp[len - 1]) {
                dp[len++] = target;
            } else {
                int search = Arrays.binarySearch(dp, 0, len, target);
                if (search < 0) {
                    search = -1 * (search + 1);
                    dp[search] = target;
                }
            }
        }
        return len;
    }
}
