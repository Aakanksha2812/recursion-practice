package Heap;


public class MinHeap {
    private int size;
    private int[] heap;

    MinHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    void insert(int value) {
        heap[size] = value;
        int current = size;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap[parent] <= heap[current])
                break;
            swap(current, parent);
            current = parent;
        }
        size++;
    }

    void swap(int current, int parent) {
        int temp = heap[current];
        heap[current] = heap[parent];
        heap[parent] = temp;
    }

    int remove() {
        if (size == 0) {
            throw new RuntimeException("Heap is Empty");
        }
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return root;
    }

    void heapifyDown(int current) {
        while (true) {
            int left = current * 2 + 1;
            int right = current * 2 + 2;
            int smallest = current;
            if (left < size && heap[left] < heap[current])
                smallest = left;
            if (right < size && heap[right] < heap[current])
                smallest = right;
            if (smallest == current)
                break;
            swap(smallest, current);
            current = smallest;

        }
    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(4);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(10);
        minHeap.insert(2);
        minHeap.remove();
        minHeap.print();
    }
}
