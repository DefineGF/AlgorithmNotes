package leetcode;

public class The287 {
    public int findDuplicate(int[] nums) {
        int n = nums[0];
        for (int i : nums) {
            n = Math.max(i, n);
        }
        int temp = 0;
        for (int i = 1; i <= n; ++i) {
            temp ^= i;
        }
        for(int i : nums) {
            temp ^= i;
        }
        return temp;
    }
}
