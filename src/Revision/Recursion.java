package Revision;

import java.util.ArrayList;

public class Recursion {
    int subArray(int i, int[] nums, int sum, int max) {
        if (i >= nums.length) {
            return max;
        }

        sum=Math.max(sum+nums[i],sum);
        max=Math.max(sum,max);
        return subArray(i+1,nums,sum,max);
    }

    public static void main(String[] args) {
        Recursion r = new Recursion();
        int[] nums = new int[]{2, 1, -3, 4, -1, 2, 1, -5, 4};
        ArrayList<ArrayList<Integer>> store = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        System.out.println("maximum sum of subarray of nums: " + r.subArray(0, nums, 0, max));
    }
}
