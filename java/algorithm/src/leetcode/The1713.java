package leetcode;

import java.util.HashMap;

public class The1713 {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < target.length; ++i) {
            map.put(target[i], i);
        }
        int N = arr.length;
        int[] dp = new int[N];
        return -1;
    }
}
