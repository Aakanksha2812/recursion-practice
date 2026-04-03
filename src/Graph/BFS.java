package Graph;

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
                return cycleBfs(i, visited, adj);
            }
        }
        return false;
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
    }
}
