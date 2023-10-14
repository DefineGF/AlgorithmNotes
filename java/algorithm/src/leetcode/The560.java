package leetcode;

import java.util.HashMap;
import java.util.Map;

public class The560 {
    static class Method1 {
        /**
         * 由于含有负数，该方法并不能通过全部测试
         */
        public int subarraySum(int[] nums, int k) {
            int left = 0, right = 0;
            int win = 0;
            int ans = 0;
            while (right < nums.length) {
                win += nums[right++];
                if (win == k) {
                    ans += 1;
                } else if (win > k) {
                    // 收缩左侧
                    while (left < right && win > k) {
                        win -= nums[left++];
                    }
                    ans += (win == k ? 1 : 0);
                }
            }
            return ans;
        }
    }

    /**
     * 前缀和：时间过长
     */
    static class Method2 {
        public int subarraySum(int[] nums, int k) {
            int[] sum = new int[nums.length];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                sum[i] = (nums[i] + sum[i - 1]);
            }

            int ans = nums[0] == k ? 1 : 0;
            for (int i = 1; i < nums.length; ++i) {
                for (int j = i; j >= 0; --j) {
                    int t = sum[i] - sum[j] + nums[j];
                    if (t == k) {
                        ans += 1;
                    }
                }
            }
            return ans;
        }
    }

    /**
     * 前缀和 && 哈希表
     */
    static class Method3 {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int pre = 0;
            int ans  = 0;
            for (int i : nums) {
                pre += i;

                if (map.containsKey(pre - k)) {
                    ans += map.get(pre - k);
                }
                map.put(pre, map.getOrDefault(pre, 0) + 1);
            }
            return ans;
        }
    }


    public static void main(String[] args) {

    }
}
