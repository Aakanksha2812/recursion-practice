package Grid;

import java.util.ArrayList;

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

    void enclave(int[][] mat, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }
        if (mat[i][j] != 1) {
            return;
        }
        if (mat[i][j] == 1) {
            mat[i][j] = 2;
        }
        enclave(mat, i + 1, j, n, m);
        enclave(mat, i, j + 1, n, m);
        enclave(mat, i - 1, j, n, m);
        enclave(mat, i, j - 1, n, m);
    }

    int dfsForEnclave(int[][] mat, int n, int m) {
        int numberOfEncllave = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (mat[i][j] == 1) {
                        enclave(mat, i, j, n, m);
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (mat[i][j] == 1) {
                    numberOfEncllave++;
                }
            }
        }
        return numberOfEncllave;
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

    void createWord(int i, int j, int n, int m, char[][] mat, StringBuilder sb, ArrayList<String> list) {

        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        sb.append(mat[i][j]);
        if (i == n - 1 && j == m - 1) {
            list.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        createWord(i + 1, j, n, m, mat, sb, list);
        createWord(i, j + 1, n, m, mat, sb, list);


        sb.deleteCharAt(sb.length() - 1);
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
        int[][] mat = new int[][]{
                {0, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        int n1 = mat.length;
        int m1 = mat[0].length;
        System.out.println(d.dfsForEnclave(mat, n1, m1));
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        char[][] mat1 = new char[][]{
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        int n2 = mat1.length;
        int m2 = mat1[0].length;
        ArrayList<String> list = new ArrayList<>();
        d.createWord(0, 0, n2, m2, mat1, new StringBuilder(""), list);
        System.out.println(list);
    }
}
