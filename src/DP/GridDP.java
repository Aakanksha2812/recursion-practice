package DP;

import java.util.Arrays;

public class GridDP {
    int uniquePath(int[][] grid, int i, int j, int n, int m, int[][] dp, boolean[][] visited) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (grid[i][j] == 1 || visited[i][j]) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        visited[i][j] = true;
        int count = 0;
        count += uniquePath(grid, i + 1, j, n, m, dp, visited);
        count += uniquePath(grid, i, j + 1, n, m, dp, visited);
        count += uniquePath(grid, i - 1, j, n, m, dp, visited);
        count += uniquePath(grid, i, j - 1, n, m, dp, visited);
        dp[i][j] = count;
        return dp[i][j];
    }

    public static void main(String[] args) {
        GridDP g = new GridDP();
        int[][] grid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] dp = new int[3][3];
        boolean[][] visited = new boolean[3][3];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(g.uniquePath(grid, 0, 0, 3, 3, dp, visited));
    }
}
