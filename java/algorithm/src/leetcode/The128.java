package leetcode;

import java.util.HashSet;

public class The128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int len = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int temp = num;
                int curLen = 1;
                while (set.contains(temp + 1)) {
                    curLen += 1;
                    temp += 1;
                }
                len = Math.max(len, curLen);
            }
        }
        return len;
    }
}
