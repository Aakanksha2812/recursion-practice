package Grid;

import java.util.ArrayList;

public class GridOperation {
    int max = 0;

    void printgrid(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    int gridmax(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (max < mat[i][j]) {
                    max = mat[i][j];
                }
            }

        }
        return max;
    }

    void printRawSum(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                sum += mat[i][j];
            }
            System.out.println(sum);
        }
    }

    void borderElement(int[][] mat) {
        int endr = mat.length - 1;
        int endc = mat[0].length - 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 || j == 0 || i == endr || j == endc) {
                    System.out.print(mat[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    void printSneakPattern(int[][] mat) {
        int round = 0;
        int i = 0, j;
        while (i < mat.length) {
            if (round % 2 == 0) {
                j = 0;
                while (j < mat[0].length) {
                    System.out.print(mat[i][j] + " ");
                    j++;
                }
            } else {
                j = mat[0].length - 1;
                while (j >= 0) {
                    System.out.print(mat[i][j] + " ");
                    j--;
                }
            }
            System.out.println();
            round++;
            i++;
        }
    }

    void sumOfNeighbours(int[][] mat, int n, int m) {
        int sum = 0;
        int lenR = mat.length;
        int lenC = mat[0].length;
        for (int i = 0; i < lenR; i++) {
            for (int j = 0; j < lenC; j++) {
                sum = 0;
                if (i > 0) {

                    sum += mat[i - 1][j];
                }
                if (i < lenR - 1) {
                    sum += mat[i + 1][j];
                }
                if (j > 0) {
                    sum += mat[i][j - 1];

                }
                if (j < lenC - 1) {
                    sum += mat[i][j + 1];

                }
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }

    void endPath(int[][] mat, int n, int m) {
        int count;
        int lenR = mat.length;
        int lenC = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 || j == 0) {
                    mat[i][j] = 1;
                } else {
                    mat[i][j] = mat[i][j - 1] + mat[i - 1][j];
                }

            }
        }
    }

    int endPath(int[][] mat, int i, int j, int n, int m) {
        if (i == n && j == m) {
            return 1;
        }
        if (i > n || j > m) {
            return 0;
        }
        return endPath(mat, i + 1, j, n, m) + endPath(mat, i, j + 1, n, m);
    }

    void endPath(int[][] mat, int i, int j, int n, int m, StringBuilder sb, ArrayList<String> list) {
        if (i == n && j == m) {
            list.add(sb.toString());
            return;
        }
        if (i > n || j > m) {
            return;
        }
        sb.append('D');
        endPath(mat, i + 1, j, n, m, sb, list);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('R');
        endPath(mat, i, j + 1, n, m, sb, list);
        sb.deleteCharAt(sb.length() - 1);
    }

    int blockedCell(int[][] mat, int i, int j, int n, int m) {
        if (i > n || j > m) {
            return 0;
        }
        if (i == n && j == m) {
            return 1;
        }
        if (mat[i][j] == 1) {
            return 0;
        }

        return blockedCell(mat, i + 1, j, n, m) + blockedCell(mat, i, j + 1, n, m);
    }

    void blockedCellPath(int[][] mat, int i, int j, int n, int m, StringBuilder sb, ArrayList<String> list) {
        if (i > n || j > m) {
            return;
        }
        if (mat[i][j] == 1) {
            return;
        }
        if (i == n && j == m) {
            list.add(sb.toString());
            return;
        }
        sb.append('D');
        blockedCellPath(mat, i + 1, j, n, m, sb, list);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('R');
        blockedCellPath(mat, i, j + 1, n, m, sb, list);
        sb.deleteCharAt(sb.length() - 1);
    }

    ArrayList<Integer> neighboursCount(int[][] mat, int n, int m, ArrayList<Integer> list) {
        int v = 0;
        int row = mat.length;
        int col = mat[0].length;
        if (n > 0) {
            v = mat[n - 1][m];
            if (v % 2 == 0) {
                list.add(v);
            }
        }
        if (m > 0) {
            v = mat[n][m - 1];
            if (v % 2 == 0) {
                list.add(v);
            }
        }
        if (n < row - 1) {
            if (mat[n + 1][m] % 2 == 0) {
                list.add(mat[n + 1][m]);
            }
        }
        if (m < col - 1) {
            if (mat[n][m + 1] % 2 == 0) {
                list.add(mat[n][m + 1]);
            }
        }
        return list;
    }

    int countConnected(int[][] mat, int i, int j, int n, int m, boolean[][] visited) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return 0;
        }
        if (mat[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int count = 1;
        count += countConnected(mat, i + 1, j, n, m, visited);
        count += countConnected(mat, i, j + 1, n, m, visited);
        count += countConnected(mat, i - 1, j, n, m, visited);
        count += countConnected(mat, i, j - 1, n, m, visited);
        /*
        //top left
        count+=countConnected(mat,i-1,j-1,n,m,visited);
        //top right
        count+=countConnected(mat,i-1,j+1,n,m,visited);
        //down left
        count+=countConnected(mat,i+1,j-1,n,m,visited);
        //down right
        count+=countConnected(mat,i+1,j+1,n,m,visited);*/

        return count;
    }

    int dfs(int[][] mat, boolean[][] visited) {
        int n = mat.length;
        int m = mat[0].length;

        int islandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    countConnected(mat, i, j, n, m, visited);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }
    int largestIland(int[][] mat,boolean[][] visited){
        int n = mat.length;
        int m = mat[0].length;
        int max=0;
        int islandCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                  int iCount=  countConnected(mat, i, j, n, m, visited);
                  if(iCount>=max){
                      max=iCount;
                  }
                }
            }
        }
        return max;
    }
    ArrayList<Integer> sizeOfIslands(int[][] mat,boolean[][] visited){
        int n = mat.length;
        ArrayList<Integer> list=new ArrayList<>();
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1 && !visited[i][j]) {
                    int iCount=  countConnected(mat, i, j, n, m, visited);
                   list.add(iCount);
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        GridOperation g = new GridOperation();
        int[][] mat = new int[][]{
                {1, 10, 9},
                {3, 4, 7},
                {9, 5, 0},
                {8, 6, 18}};
        g.printgrid(mat);
        System.out.println(g.gridmax(mat));
        g.printRawSum(mat);
        g.borderElement(mat);
        g.printSneakPattern(mat);
        System.out.println("sum of neighbours ");
        g.sumOfNeighbours(mat, 3, 1);
        int[][] grid = new int[3][3];
        g.endPath(grid, 2, 3);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(g.endPath(mat, 0, 0, 1, 2));
        ArrayList<String> list = new ArrayList<>();
        g.endPath(mat, 0, 0, 1, 2, new StringBuilder(""), list);
        System.out.println(list);
        int[][] mat1 = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(g.blockedCell(mat1, 0, 0, 2, 2));
        ArrayList<String> list1 = new ArrayList<>();
        g.blockedCellPath(mat1, 0, 0, 2, 2, new StringBuilder(""), list1);
        System.out.println(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println(g.neighboursCount(mat, 1, 1, list2));
        int[][] mat2 = new int[][]{
                {1, 1, 0},
                {1, 0, 0},
                {0, 1, 1},
                {0, 1, 1}
        };
        int[][] mat3=new int[][]{
                { 1 ,1, 0, 1},
                { 1 ,0, 0, 0},
                {  0 ,0 ,1 ,1},
                {0 ,0 ,1, 1}
        };
        boolean[][] visited2 = new boolean[4][3];
        System.out.println(g.countConnected(mat2, 0, 0, 4, 3, visited2));
        System.out.println("island count");
        boolean[][] visited3 = new boolean[4][3];
        System.out.println(g.dfs(mat2, visited3));
        boolean[][] visited4=new boolean[4][4];
        System.out.println(g.largestIland(mat3,visited4));
        boolean[][] visited5=new boolean[4][4];
        System.out.println(g.sizeOfIslands(mat3,visited5));
    }
}
