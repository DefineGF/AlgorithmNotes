package leetcode;

public class The413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 0;
        int i = 0, j = 1;
        int result = 0;
        while (i <= n - 3) {
            int flag = Integer.MIN_VALUE;
            while (j < n) {
                if (flag == Integer.MIN_VALUE) {
                    flag = nums[j] - nums[j -1];
                } else if (nums[j] - nums[j - 1] != flag) {
                    break;
                }
                j++;
            }
            result += helper(j - i);
            i = j - 1;
        }
        return result;
    }

    private int helper(int n) {
        if (n <= 2) return 0;
        int result = 0;
        for (int i = 1; i <= n - 2; ++i) {
            result += i;
        }
        return result;
    }
}
