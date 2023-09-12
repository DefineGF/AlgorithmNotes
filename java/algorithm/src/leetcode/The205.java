package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class The205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        return func(s, t) && func(t, s);
    }

    private boolean func(String s, String t) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            List<Integer> tmp = map.get(c);
            if (tmp == null) {
                tmp = new LinkedList<>();
                map.put(c, tmp);
            } else {
                char c2 = t.charAt(i);
                for (int k : tmp) {
                    if (c2 != t.charAt(k)) {
                        return false;
                    }
                }
            }
            tmp.add(i);
        }
        return true;
    }
}
