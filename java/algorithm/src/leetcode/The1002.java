package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class The1002 {
    public List<String> commonChars(String[] words) {
        LinkedList<String> ls = new LinkedList<>();
        int n = words.length;
        if (n < 2) {
            return ls;
        }
        int[][] record = new int[words.length][26];
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                record[i][c - 'a'] += 1;
            }
        }

        for (int i = 0; i < 26; ++i) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; ++j) {
                if (record[j][i] < min) {
                    min = record[j][i];
                }
            }
            while (min-- > 0) {
                char tmp = (char) (i + 'a');
                ls.add(String.valueOf(tmp));
            }
        }
        return ls;
    }
}
