package leetcode;

import java.util.PriorityQueue;

public class The239 {
    /**
     * 算法思想：
     * 使用大根堆记录窗口内的：（元素值，元素索引）
     * 当获取当前窗口最大值时，如果大根堆堆顶元素的下标不在当前窗口中，则退出大根堆
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (i1, i2) -> i2[0] - i1[0]); // 大根堆
        for (int i = 0; i < k; ++i) {
            queue.add(new int[] {nums[i], i});
        }
        int len = nums.length - k + 1;
        int[] ans = new int[len];
        ans[0] = queue.peek()[0];
        for (int i = 1; i < len; ++i) {
            int next = nums[i + k - 1];
            queue.add(new int[] {next, i + k - 1});
            while (queue.size() > 0 && queue.peek()[1] < i) {
                queue.poll();
            }
            ans[i] = queue.peek()[0];
        }
        return ans;
    }
}
