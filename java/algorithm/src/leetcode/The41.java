package leetcode;

public class The41 {
    public int firstMissingPositive(int[] nums) {
        final int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }

        for (int i = 0; i < n; ++i) {
            int t = Math.abs(nums[i]);
            if (t >= 1 && t <= n) {
                if (nums[t - 1] > 0) {
                    nums[t - 1] *= -1;
                }
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) return i + 1;
        }
        return n + 1;
    }
}
