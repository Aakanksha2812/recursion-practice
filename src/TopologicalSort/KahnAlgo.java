package TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Print.PrintFunction.printArrayMethod;

public class KahnAlgo {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];


        for (int[] edge : prerequisites) {

            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            count++;
            for (int neighbor : adj.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return count == numCourses;
    }

    public int[] canFinish2(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];


        for (int[] edge : prerequisites) {

            int course = edge[0];
            int prerequisite = edge[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        int count = 0;
        while (!q.isEmpty()) {
            int current = q.poll();
            count++;
            ans[idx++] = current;
            for (int neighbor : adj.get(current)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        KahnAlgo k = new KahnAlgo();
        int numCourse = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        System.out.println("can finish course is " + k.canFinish(numCourse, prerequisites));
        int[] ans = k.canFinish2(numCourse, prerequisites);
        printArrayMethod(ans);
    }
}
