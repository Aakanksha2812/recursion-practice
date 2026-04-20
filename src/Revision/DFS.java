package Revision;

public class DFS {
    void island(int[][] grid, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;

        island(grid, i + 1, j, n, m);
        island(grid, i, j + 1, n, m);
        island(grid, i - 1, j, n, m);
        island(grid, i, j - 1, n, m);

    }

    int countIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    island(grid, i, j, n, m);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DFS d = new DFS();
        int[][] grid = new int[][]{
                {1, 1, 0},
                {0, 1, 0},
                {1, 0, 1}
        };
        System.out.println(d.countIsland(grid));
    }
}
