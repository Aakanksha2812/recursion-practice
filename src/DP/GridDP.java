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

    int minPathSum(int[][] grid, int i, int j, int n, int m, int[][] dp) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = grid[i][j] + Math.min(minPathSum(grid, i + 1, j, n, m, dp), minPathSum(grid, i, j + 1, n, m, dp));
        return dp[i][j];
    }

    int uniquePathObstacles(int[][] grid, int i, int j, int n, int m, int[][] dp2) {
        if (i >= n || j >= m) {
            return 0;
        }
        if (dp2[i][j] != -1) {
            return dp2[i][j];
        }
        if (grid[i][j] == 1) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        int right = 0;
        int down = 0;
        right = uniquePathObstacles(grid, i, j + 1, n, m, dp2);
        down = uniquePathObstacles(grid, i + 1, j, n, m, dp2);
        dp2[i][j] = right + down;
        return dp2[i][j];

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
        int[][] grid1 = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] dp1 = new int[3][3];
        //  boolean[][] visited = new boolean[3][3];
        for (int[] arr : dp1) {
            Arrays.fill(arr, -1);
        }
        System.out.println(g.uniquePath(grid, 0, 0, 3, 3, dp, visited));
        System.out.println(g.minPathSum(grid1, 0, 0, 3, 3, dp1));
        int[][] grid2 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int[][] dp2 = new int[3][3];
        for (int[] arr : dp2) {
            Arrays.fill(arr, -1);
        }
        System.out.println("unique path with obstacles " + g.uniquePathObstacles(grid2, 0, 0, 3, 3, dp2));
    }
}

