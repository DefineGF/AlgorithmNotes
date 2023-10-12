package leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class The56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (ints, t1) -> {
            if (ints[0] == t1[0]) {
                return ints[1] - t1[1];
            }
            return ints[0] - t1[0];
        });

        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            int[] cur = intervals[i];
            int[] last = result.getLast();
            if (cur[0] > last[1]) {
                result.add(cur);
            } else {
                int t = Math.max(cur[1], last[1]);
                result.pollLast();
                result.addLast(new int[]{last[0], t});
            }
        }
        int[][] ans = new int[result.size()][2];
        int index = 0;
        for (int[] tmp : result) {
            ans[index++] = tmp;
        }
        return ans;
    }
}
