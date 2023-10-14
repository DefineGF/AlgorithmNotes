package leetcode;

import java.util.Arrays;

public class The31 {
    /**
     * 下一个排列
     * 算法思想：
     * 1. 从后向前，找到最长的递增索引，记为 i, 即 [i, len) 为递增序列；
     * 2. 从后向前查找，获取刚好大于 num[i - 1] 元素的下标，并与 num[i] 交换；
     * 3. 最后倒置 [i, len) 所有元素即可
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i == 0) {
            for (int j = 0; j < len / 2; ++j) {
                swap(nums, j, len - 1 - j);
            }
            return;
        }

        for (int j = len - 1; j >= i; j--) {
            if (nums[j] > nums[i - 1]) {
                swap(nums, j, i - 1);
                break;
            }
        }

        int t = len - 1 + i;
        for (int j = i; j <= t / 2; ++j) {
            swap(nums, j, t - j);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] data = {1, 5, 4, 3, 2};
        new The31().nextPermutation(data);
        System.out.println(Arrays.toString(data));
    }
}
