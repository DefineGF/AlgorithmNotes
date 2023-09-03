package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class The1713 {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; ++i) {
            map.put(target[i], i);
        }
        int N = arr.length;
        int[] dp = new int[N];
        int len = 0;
        for (int n : arr) {
            int index = map.getOrDefault(n, -1);
            if (index != -1) {
                if (len == 0 || index > dp[len - 1]) {
                    dp[len++] = index;
                } else {
                    // 二分法查找
                    int insertIndex = Arrays.binarySearch(dp, 0, len, index);
                    if (insertIndex < 0) {
                        int t = -1 * (insertIndex + 1);
                        dp[t] = index;
                    }
                }
            }
        }
        return target.length - len;
    }
}
