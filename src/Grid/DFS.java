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

    void createWordWithfourDireaction(int i, int j, int n, int m, char[][] mat, StringBuilder sb, boolean[][] visited, ArrayList<String> list) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }

        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        sb.append(mat[i][j]);
        if (i == n - 1 && j == m - 1) {
            list.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            visited[i][j] = false;
            return;
        }
        createWordWithfourDireaction(i + 1, j, n, m, mat, sb, visited, list);
        createWordWithfourDireaction(i, j + 1, n, m, mat, sb, visited, list);
        createWordWithfourDireaction(i - 1, j, n, m, mat, sb, visited, list);
        createWordWithfourDireaction(i, j - 1, n, m, mat, sb, visited, list);
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);
    }

    boolean searchWord(int i, int j, int n, int m, char[][] mat, String word, int k, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        if (visited[i][j] || mat[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) {

            return true;
        }
        visited[i][j] = true;
        boolean found = searchWord(i + 1, j, n, m, mat, word, k + 1, visited) || searchWord(i, j + 1, n, m, mat, word, k + 1, visited) ||
                searchWord(i - 1, j, n, m, mat, word, k + 1, visited) || searchWord(i, j - 1, n, m, mat, word, k + 1, visited);
        visited[i][j] = false;
        return found;
    }

    boolean wordSearch(char[][] grid, int i, int j, int n, int m, int k, String s, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        if (visited[i][j] || grid[i][j] != s.charAt(k)) {
            return false;
        }
        if (k == s.length() - 1) {
            return true;
        }
        visited[i][j] = true;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int d = 0; d < 4; d++) {
            if (wordSearch(grid, i + dx[d], j + dy[d], n, m, k + 1, s, visited)) {
                //    visited[i][j] = false;
                return true;
            }
        }

        visited[i][j] = false;
        return false;
    }

    void combinationSum(int i, int[] num, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (target == 0) {
            store.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || i == num.length) {
            return;
        }
        list.add(num[i]);
        combinationSum(i, num, target - num[i], list, store);
        list.remove(list.size() - 1);
        combinationSum(i + 1, num, target, list, store);

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
        char[][] mat2 = new char[][]{
                {'A', 'B', 'C'},
                {'A', 'E', 'D'}

        };
        int n2 = mat1.length;
        int m2 = mat1[0].length;
        ArrayList<String> list = new ArrayList<>();
        d.createWord(0, 0, n2, m2, mat1, new StringBuilder(""), list);
        System.out.println(list);
        boolean[][] visited1 = new boolean[n2][m2];
        ArrayList<String> list2 = new ArrayList<>();
        d.createWordWithfourDireaction(0, 0, n2, m2, mat1, new StringBuilder(""), visited1, list2);
        System.out.println(list2);
        boolean[][] visited2 = new boolean[n2][m2];
        System.out.println(d.searchWord(0, 0, n2, m2, mat1, "ABCEFI", 0, visited2));
        boolean[][] visited3 = new boolean[n2][m2];
        System.out.println(d.wordSearch(mat2, 0, 0, 2, 3, 0, "ABED", visited3));
        ArrayList<ArrayList<Integer>> store1 = new ArrayList<>();
        int[] nums = new int[]{2, 3, 6, 7};
        d.combinationSum(0, nums, 7, new ArrayList<>(), store1);
        System.out.println(store1);
    }
}
