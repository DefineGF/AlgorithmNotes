package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class The207 {
    /**
     * 常规拓扑排序：
     * - 首先使用数组记录入度；使用 HashMap 记录该节点的邻居节点；
     * - 遍历：每次选出 入度为0 && 没有被访问过的：
     *      - 如果所有节点均访问过，return true；
     *      - 如果有节点没有访问过，同时入度不为0：return false;
     * - 其他情况则访问，同时将其邻居节点入度-1；
     */
    static class Method1 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] inputs = new int[numCourses];                 // 记录入度
            boolean[] visited = new boolean[numCourses];

            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int[] arr : prerequisites) {
                inputs[arr[0]] += 1;
                List<Integer> tmp = map.computeIfAbsent(arr[1], k -> new LinkedList<>());
                tmp.add(arr[0]);
            }

            while (true) {
                int next = -1;
                boolean visTmp = true;
                for (int i = 0; i < numCourses; ++i) {
                    visTmp &= visited[i];
                    if (inputs[i] == 0 && !visited[i]) {
                        next = i;
                        break;
                    }
                }
                if (next == -1) {
                    return visTmp;
                }
                visited[next] = true;
                if (map.get(next) != null) {
                    for (Integer i : map.get(next)) {
                        inputs[i] -= 1;
                    }
                }
            }
        }
    }

    /**
     * 深度优先搜索：
     * visit 记录三个状态：
     * - 0：未访问过；
     * - 1：正在访问：比如深度优先搜索中，a - b - c: 访问到c时，a和b状态 = 1，表示此时还未回溯到此；
     *      当出现 a - b - c - a 情况时，表明出现环，返回 false
     * - 2：已经访问完毕
     */
    static class Method2 {
        List<List<Integer>> edges;
        int[] visited;
        boolean valid = true;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            edges = new ArrayList<>();
            for (int i = 0; i < numCourses; ++i) {
                edges.add(new ArrayList<>());
            }
            visited = new int[numCourses];
            for (int[] info : prerequisites) {
                edges.get(info[1]).add(info[0]);
            }

            for (int i = 0; i < numCourses && valid; ++i) {
                if (visited[i] == 0) {
                    dfs(i);
                }
            }
            return valid;
        }

        public void dfs(int u) {
            visited[u] = 1;
            for (int v : edges.get(u)) {
                if (visited[v] == 0) {
                    dfs(v);
                    if (!valid) {
                        return;
                    }
                } else if (visited[v] == 1) {
                    //出现环
                    valid = false;
                    return;
                }
            }
            visited[u] = 2;
        }
    }
}
