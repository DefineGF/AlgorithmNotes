package leetcode;

import java.util.HashSet;
import java.util.Objects;

public class The994 {
    public static void main(String[] args) {
        The994 the994 = new The994();
        int[][] data = {{2,1,1},{1,1,0},{0,1,1}};
        the994.orangesRotting(data);
    }
    private static void logArray(int[][] data) {
        System.out.println("打印数组: ");
        for (int[] a : data) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public int orangesRotting(int[][] grid) {
        int count = 0;
        int R = grid.length, C = grid[0].length;
        HashSet<Pair> badSet = new HashSet<>();
        for (int i = 0; i < R; ++i) {
            for (int j = 0; j < C; ++j) {
                if (grid[i][j] == 1) {
                    count += 1;
                } else if (grid[i][j] == 2) {
                    badSet.add(new Pair(i, j));
                }
            }
        }

        int[] dir = {-1, 0, 1, 0, -1};

        HashSet<Pair> temp = new HashSet<>();
        int times = 0;
        while (count > 0) {
            times += 1;
            for (Pair cur : badSet) {
                for (int i = 0; i < 4; ++i) {
                    int x = cur.x + dir[i];
                    int y = cur.y + dir[i + 1];
                    if (x >= 0 && x < R && y >= 0 && y < C && grid[x][y] == 1) {
                        temp.add(new Pair(x, y));
                    }
                }
            }

            if (temp.size() == 0) {
                return -1;
            }

            count -= temp.size();
            for (Pair cur : temp) {
                int x = cur.x, y = cur.y;
                grid[x][y] = 2;
            }
            badSet.clear();
            badSet.addAll(temp);
            temp.clear();
            logArray(grid);
        }
        return times;
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
