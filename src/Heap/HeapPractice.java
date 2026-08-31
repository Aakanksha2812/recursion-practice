package Heap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

import static Print.PrintFunction.printArrayMethod;

public class HeapPractice {
    class Node {
        int value;
        int arrayIndex;
        int elementIndex;

        Node(int value, int arrayIndex, int elementIndex) {
            this.value = value;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }
    
    static int kthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);

            } else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }

    static int kthSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);

            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }
    static int[] topKLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (pq.size() < k) {
                pq.offer(num);

            } else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }
        int[] ans=new int[k];
        int idx=0;
        while (!pq.isEmpty())
        {
            ans[idx++]=pq.poll();
        }
        return ans;
    }
    static int[] topKSmallest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for (int num:nums){
            if (pq.size()<k){
                pq.offer(num);
            }else if (pq.peek()>num){
                pq.poll();
                pq.offer(num);
            }
        }
        int[] ans=new int[k];
        int idx=0;
        while (!pq.isEmpty())
        {
            ans[idx++]=pq.poll();
        }
        return ans;
    }
    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;


        System.out.println("kth largest element " + kthLargest(nums, k));
        System.out.println("kth smallest element "+kthSmallest(nums,2));
        int[] ans1=topKLargest(nums,3);
        printArrayMethod(ans1);
        System.out.println();
        int[] ans2=topKSmallest(nums,3);
        printArrayMethod(ans2);
    }
}