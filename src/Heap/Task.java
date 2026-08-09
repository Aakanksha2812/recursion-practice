package Heap;

import java.util.PriorityQueue;

class Task {
    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    void priorityFunc() {
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            int result = Integer.compare(b.priority, a.priority);

            if (result != 0) {
                return result;
            }
            return Integer.compare(a.name.length(), b.name.length());
        });
        pq.offer(new Task("A", 10));
        pq.offer(new Task("AB", 10));
        pq.offer(new Task("AA", 10));
        pq.offer(new Task("ABC", 10));
        pq.offer(new Task("B", 100));
        pq.offer(new Task("C", 90));
        pq.offer(new Task("D", 1000));
        pq.offer(new Task("E", 20));
        pq.offer(new Task("F", 30));

        while (!pq.isEmpty()) {
            Task t = pq.poll();
            System.out.println("Name: " + t.name + " Priority: " + t.priority);
        }

    }

    public static void main(String[] args) {
        Task t = new Task("A", 10);
        t.priorityFunc();
    }
}