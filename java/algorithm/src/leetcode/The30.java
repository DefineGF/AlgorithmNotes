package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class The30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();

        int step  = words.length;
        int count = words[0].length();
        int len = step * count;
        if (s.length() < len) {
            return result;
        }
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> temp = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int i = 0, j = 0;
        while (i <= s.length() - len) {
            if (!func1(s.charAt(i), words)) {
                i++;
                continue;
            }
            int k = Math.max(j, i);
            while (k + count <= s.length() && k + count - i <= len) {
                String st = s.substring(k, k + count);
                if (map.containsKey(st)) {
                    temp.put(st, temp.getOrDefault(st, 0) + 1);
                } else {
                    // 当前 单词 不符合要求
                    temp.clear();
                    break;
                }
                k += count;
            }
            if (func2(temp, map)) {
                result.add(i);
                j = k;
            }
            i += 1;
        }
        return result;
    }

    private boolean func1(char c, String[] words) {
        for (String word : words) {
            if (word.charAt(0) == c) {
                return true;
            }
        }
        return false;
    }

    private boolean func2(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        if (map1.size() != map2.size()) return false;

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
