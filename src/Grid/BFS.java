package Grid;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll();
                int i = cell[0];
                int j = cell[1];

                for (int d = 0; d < 4; d++) {
                    int ni = i + dx[d];
                    int nj = j + dy[d];

                    if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length && grid[ni][nj] == 1) {
                        grid[ni][nj] = 2;
                        queue.add(new int[]{ni, nj});
                        fresh--;
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    int orangeRoatting1(int[][] grid) {
        Queue<int[]> rotten = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    rotten.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!rotten.isEmpty() && fresh > 0) {
            int size = rotten.size();
            boolean rottedThisRound = false;  // ⭐ important

            for (int i = 0; i < size; i++) {
                int[] cell = rotten.poll();
                int r = cell[0], c = cell[1];

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        rotten.add(new int[]{nr, nc});
                        fresh--;
                        rottedThisRound = true; // ⭐ mark change
                    }
                }
            }

            if (rottedThisRound) time++;  // ⭐ increment only if spread happened
        }

        return fresh == 0 ? time : -1;
    }

    void bfsIsland(int[][] grid, int i, int j, int n, int m) {
        Queue<int[]> pos = new LinkedList<>();
        pos.add(new int[]{i, j});
        grid[i][j] = 0;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pos.isEmpty()) {
            int[] cell = pos.poll();
            for (int[] d : dir) {
                int ni = cell[0] + d[0];
                int nj = cell[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 1) {
                    grid[ni][nj] = 0;
                    pos.add(new int[]{ni, nj});
                }
            }
        }
    }

    int numberOfIslan(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int countIsland = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {

                    countIsland++;
                    System.out.println("found " + countIsland);
                    bfsIsland(grid, i, j, n, m);
                }
            }
        }
        return countIsland;
    }

    int[][] distanceZeroMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> zero = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    visited[i][j] = true;
                    zero.add(new int[]{i, j});
                }
            }
        }
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!zero.isEmpty()) {
            int[] cell = zero.poll();

            for (int[] d : dir) {
                int ni = cell[0] + d[0];
                int nj = cell[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && !visited[ni][nj]) {
                    grid[ni][nj] = grid[cell[0]][cell[1]] + 1;
                    zero.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                }
            }
        }
        return grid;
    }

    void shortestDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;
        if(grid==null || n==0){
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dir) {
                int ni = cell[0] + d[0];
                int nj = cell[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == 2147483647) {
                    grid[ni][nj] = grid[cell[0]][cell[1]] + 1;

                    queue.add(new int[]{ni, nj});
                }
            }
        }
    }

    void fillColour(int[][] grid, int i, int j, int newColor) {
        Queue<int[]> colorCell = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int storeColor = grid[i][j];
        grid[i][j] = newColor;
        if (storeColor == newColor) {
            return;
        }
        colorCell.add(new int[]{i, j});
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!colorCell.isEmpty()) {
            int[] cell = colorCell.poll();

            for (int[] d : dir) {
                int ni = cell[0] + d[0];
                int nj = cell[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] == storeColor) {
                    grid[ni][nj] = newColor;
                    colorCell.add(new int[]{ni, nj});
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS b = new BFS();
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        // System.out.println( b.orangeRoatting1(grid));
        int[][] grid1 = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 1},
                {1, 0, 0}
        };
        System.out.println("Hi");
        System.out.println("number of island " + b.numberOfIslan(grid1));
        int[][] grid2 = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        b.distanceZeroMatrix(grid2);
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                System.out.print(grid2[i][j] + " ");
            }
            System.out.println();
        }
        int[][] grid3 = new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        System.out.println("flood fill");
        b.fillColour(grid3, 1, 1, 2);
        for (int i = 0; i < grid3.length; i++) {
            for (int j = 0; j < grid3[0].length; j++) {
                System.out.print(grid3[i][j] + " ");
            }
            System.out.println();
        }
        int[][] Input = new int[][]
                {
                        {2147483647, -1, 0, 2147483647},
                        {2147483647, 2147483647, 2147483647, -1},
                        {2147483647, -1, 2147483647, -1},
                        {0, -1, 2147483647, 2147483647}
                };
        b.shortestDistance(Input);
        for (int i = 0; i < Input.length; i++) {
            for (int j = 0; j < Input[0].length; j++) {
                System.out.print(Input[i][j] + " ");
            }
            System.out.println();
        }
    }
}
