package leetcode;

import java.util.*;

public class The218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();

        List<int[]> ps = new ArrayList<>();
        for (int[] b : buildings) {
            int L = b[0], R = b[1], H = b[2];
            ps.add(new int[] {L, -H});
            ps.add(new int[] {R, H});
        }

        ps.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a); // 大根堆
        int prev = 0;
        queue.add(prev);

        for (int[] p : ps) {
            int x = p[0], height = p[1];
            if (height < 0) {
                queue.add(-1 * height);
            } else {
                queue.remove(height);
            }

            int highest = queue.peek();
            if (highest != prev) {
                List<Integer> tmp = new LinkedList<>();
                tmp.add(x);
                tmp.add(highest);
                ans.add(tmp);
                prev = highest;
            }
        }
        return ans;
    }
}
