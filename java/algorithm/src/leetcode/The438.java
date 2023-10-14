package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class The438 {
    int[] count = new int[26];

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        for (char c : p.toCharArray()) {
            count[c - 'a'] += 1;
        }
        int len = s.length() - p.length() + 1;
        int target = 0;
        int win    = 0;
        for (int i = 0; i < p.length(); ++i) {
            target += p.charAt(i);
            win    += s.charAt(i);
        }
        if (target == win && check(s.substring(0, p.length()))) {
            ls.add(0);
        }

        for (int i = 1; i < len; ++i) {
            char prev = s.charAt(i - 1);
            char next = s.charAt(i + p.length() - 1);
            if (prev == next && ls.get(ls.size() - 1) == (i - 1)) {
                ls.add(i);
            } else {
                win = win + next - prev;
                if (win == target && check(s.substring(i, i + p.length()))) {
                    ls.add(i);
                }
            }
        }
        return ls;
    }

    private boolean check(String s) {
        int[] copy = Arrays.copyOf(count, count.length);
        for (char c : s.toCharArray()) {
            if (--copy[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
