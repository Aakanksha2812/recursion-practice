package Graph;

import static Print.PrintFunction.printArrayMethod;

class UnionFind {

    int[] parent;

    UnionFind(int n) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int node) {
        while (parent[node] != node) {
            node = parent[node];
        }
        return node;
    }

    void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        if (parent2 != parent1) {
            parent[parent2] = parent1;
        }

    }

    boolean areConnected(int node1, int node2) {
        return find(node1) == find(node2);

    }

    boolean hasCycle(int n, int[][] edges) {
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            if (find(u) == find(v)) {
                return true;
            }
            union(u, v);
        }
        return false;
    }

    int countComponents(int n, int[][] edges) {
        int components = n;
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            if (find(u) != find(v)) {
                union(u, v);
                components--;
            }
        }
        return components;
    }

    int[] findRedundantConnection(int[][] edges) {
        for (int[] arr : edges) {
            int u = arr[0];
            int v = arr[1];
            if (find(u) == find(v)) {
                return new int[]{u, v};
            }
            union(u, v);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
     /*   uf.union(0, 1);
        uf.union(1, 2);
        System.out.println("parent of node " + uf.find(0));
        System.out.println("parent of node " + uf.find(1));
        System.out.println("parent of node " + uf.find(2));
        System.out.println("is node 0 and 1 connected " + uf.areConnected(0, 1));
        System.out.println("is node 1 and 2 connected " + uf.areConnected(1, 2));
        System.out.println("is node 2 and 3 connected " + uf.areConnected(2, 3));
        int n = 5;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {2, 3},
                {3, 0}
        };
        System.out.println("graph contain cycle "+uf.hasCycle(n,edges));
        int n = 6;

        int[][] edges = {
                {0, 1},
                {1, 2},
                {3, 4}
        };
        System.out.println("components for graph " + uf.countComponents(n, edges));*/
        int[][] edges = {
                {1, 2},
                {1, 3},
                {2, 3}
        };
        int[][] edges2 = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        System.out.println("redundant connection: ");
        int[] ans = uf.findRedundantConnection(edges2);
        printArrayMethod(ans);
    }
}
