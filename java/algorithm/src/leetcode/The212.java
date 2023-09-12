package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class The212 {
    private final int[] dir = {-1, 0, 1, 0, -1};
    private final HashSet<String> result = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length, n = board[0].length;

        for (String word : words) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (board[i][j] == word.charAt(0)) {
                        boolean[][] visited = new boolean[m][n];
                        visited[i][j] = true;
                        DFS(board, visited, i, j, word, 1);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     *
     * @param index: 表示下一字符索引
     */
    private void DFS(char[][] board, boolean[][] visited, int x, int y, String s, int index) {
        int m = board.length, n = board[0].length;

        if (index == s.length()) {
            result.add(s);
            return;
        }

        for (int d = 0; d < 4; ++d) {
            int xt = x + dir[d];
            int yt = y + dir[d + 1];
            if (xt < 0 || xt >= m || yt < 0 || yt >= n || visited[xt][yt] || s.charAt(index) != board[xt][yt]) {
                continue;
            }
            visited[xt][yt] = true;
            DFS(board, visited, xt, yt, s, index + 1);
            visited[xt][yt] = false;
        }
    }


    public static void main(String[] args) {
        String[] data = {"aaa"};
        char[][] board = {{'a', 'a'}};
        System.out.println(new The212().findWords(board, data));
    }
}
