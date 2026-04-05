package Graph;

import javax.swing.plaf.IconUIResource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    void bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    int connctedCity(int n, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                visited[i] = true;
                bfs(i, adj, visited);

            }
        }
        return count;
    }

    ArrayList<Integer> shortestPath(int n, int[][] edges, int source) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // Arrays.fill(distance,-1);
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int num : adj.get(node)) {
                if (!visited[num]) {
                    visited[num] = true;
                    list.add(num);
                    queue.add(num);
                }
            }
        }
        return list;
    }

    int[] shortestPath2(int n, int[][] edges, int source) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        distance[source] = 0;
        queue.add(source);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return distance;
    }

    boolean cycleBfs(int start, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new int[]{start, -1});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int node = cell[0];
            int parent = cell[1];
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isCyclePresent(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (cycleBfs(i, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[] nearestOne(int n, int[][] edges, int[] values) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        for (int i = 0; i < n; i++) {
            if (values[i] == 1) {
                queue.add(i);
                distance[i] = 0;
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return distance;

    }

    void dfs(int[][] grid, int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for (int d = 0; d < 4; d++) {

            dfs(grid, i + dx[d], j + dy[d], n, m);
        }

    }

    int numIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    // dfs(grid, i, j, n, m);
                    bfsNumofIsland(grid, i, j, n, m);

                }
            }

        }

        return count;
    }

    void bfsNumofIsland(int[][] grid, int i, int j, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = 0;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dir) {
                int nx = cell[0] + d[0];
                int ny = cell[1] + d[1];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1) {
                    grid[nx][ny] = 0;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }



    public static void main(String[] args) {
        BFS b = new BFS();
        int n = 5;
        int[][] edges = new int[][]{
                {0, 1},
                {1, 2},
                {3, 4}
        };
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(b.connctedCity(n, adj));
        int[][] edges2 = new int[][]{
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3},
                {3, 4},
                {4, 5}
        };
        ArrayList<Integer> list = b.shortestPath(6, edges2, 0);
        System.out.println(list);
        int[] ans = b.shortestPath2(6, edges2, 0);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        int[][] edges3 = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        System.out.println("Cycle detacted " + b.isCyclePresent(3, edges3));
        int[][] edges4 = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[] values = new int[]{0, 0, 1, 0, 0, 1};
        int[] distance = b.nearestOne(6, edges4, values);
        for (int i = 0; i < distance.length; i++) {
            System.out.print(distance[i] + " ");
        }
        int[][] grid = new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };
        System.out.println("number of island " + b.numIslands(grid));

    }
}
