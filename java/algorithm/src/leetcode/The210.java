package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class The210 {
    int[] inputs; // 入度
    HashMap<Integer, List<Integer>> map;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<>();
        map = new HashMap<>();
        inputs = new int[numCourses];


        for (int[] tmp : prerequisites) {
            int a = tmp[1];
            int b = tmp[0];
            inputs[b] += 1; // 入度加 1
            List<Integer> ls = map.computeIfAbsent(a, k -> new ArrayList<>());
            ls.add(b);
        }

        int index;
        while ((index = next()) != -1) {
            result.add(index);
            inputs[index] = -1;
            if (map.containsKey(index)) {
                for (int i : map.get(index)) {
                    inputs[i] -= 1;
                }
            }
        }
        if (result.size() == 0) {
            return new int[0];
        }

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    public int next() {
        int n = inputs.length;
        for (int i = 0; i < n; ++i) {
            if (inputs[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
