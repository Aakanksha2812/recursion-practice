package Grid;

public class DFS {
    void surroundedRegionApproach1(char[][] grid, int i, int j, int n, int m, boolean[][] visted) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == '0' && (i == n - 1 || j == n - 1 || i == m - 1 || j == m - 1)) {
            return;
        }
        if (visted[i][j]) {
            return;
        }
        visted[i][j] = true;
        if (grid[i][j] == '0') {
            grid[i][j] = 'X';
        }
        surroundedRegionApproach1(grid, i + 1, j, n, m, visted);
        surroundedRegionApproach1(grid, i, j + 1, n, m, visted);
        surroundedRegionApproach1(grid, i - 1, j, n, m, visted);
        surroundedRegionApproach1(grid, i, j - 1, n, m, visted);
    }

    void surroundedRegion(char[][] grid, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] != 'O') {
            return;
        }
        if (grid[i][j] == 'O') {
            grid[i][j] = 'S';
        }
        surroundedRegion(grid, i + 1, j, n, m);
        surroundedRegion(grid, i, j + 1, n, m);
        surroundedRegion(grid, i - 1, j, n, m);
        surroundedRegion(grid, i, j - 1, n, m);
    }

    void dfsMehod(char[][] grid, int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 'O') {
                        surroundedRegion(grid, i, j, n, m);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
                if (grid[i][j] == 'S') {
                    grid[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String args[]) {
        DFS d = new DFS();
        char[][] grid = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        //      d.surroundedRegionApproach1(grid,0,0,n,m,visited);
        d.dfsMehod(grid, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
