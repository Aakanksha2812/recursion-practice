package Graph;

import java.util.ArrayList;

public class DFS {
    int connectedComponent(int[][] grid, int length) {
        int count = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : grid) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                count++;
                dfsConncted(i, visited, adj);
            }

        }
        return count;
    }

    void dfsConncted(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        visited[i] = true;
        for (int neighbor : adj.get(i)) {
            if (!visited[neighbor]) {

                dfsConncted(neighbor, visited, adj);
            }
        }
    }

    boolean dfsPath(int node, int destination, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        if (node == destination) {
            return true;
        }
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfsPath(neighbor, destination, visited, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return (dfsPath(source, destination, visited, adj));

    }

    void dfs(int i, int[][] grid, boolean[] visited, int n) {
        visited[i] = true;
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1 && !visited[j]) {
                dfs(j, grid, visited, n);
            }
        }
    }

    int noOfProvince(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, grid, visited, n);

            }
        }
        return count;
    }

    public static void main(String[] args) {
        DFS d = new DFS();
        int[][] edges5 = new int[][]
                {{0, 1}, {1, 2}, {3, 4}
                };
        System.out.println(d.connectedComponent(edges5, 5));
        int[][] edges6 = new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        System.out.println("yes it is valid path " + d.validPath(6, edges6, 0, 5));
        int[][] isConnected = new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println("number of provinces " + d.noOfProvince(isConnected));
    }
}
