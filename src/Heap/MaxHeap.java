package Heap;

public class MaxHeap {
    private int size = 0;
    private int[] heap;

    MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    void insert(int val) {
        heap[size] = val;
        int current = size;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap[parent] >= heap[current])
                break;
            swap(current, parent);
            current = parent;
        }
        size++;
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
            int largest = current;
            if (left < size && heap[left] > heap[current])
                largest = left;
            if (right < size && heap[right] > heap[current])
                largest = right;
            if (largest == current)
                break;
            swap(largest, current);
            current = largest;

        }
    }
    void swap(int current, int parent) {
        int temp = heap[current];
        heap[current] = heap[parent];
        heap[parent] = temp;
    }

    void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(5);
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(10);
        maxHeap.insert(2);
        maxHeap.remove();
        maxHeap.print();
    }
}
