package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Print.PrintFunction.printArrayMethod;

public class Level2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {

                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left - 1] && left < right) {
                        left++;
                    }
                } else if (sum < 0) {
                    left++;

                } else {
                    right--;
                }
            }
        }
        return ans;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] >= pivot) {
                if (nums[right] <= pivot) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
                right--;

            } else {
                left++;
            }

        }
        return nums;
    }

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int pos = 0, neg = 1;
        while (pos < n && neg < n) {
            if (nums[pos] >= 0) pos += 2;
            else if (nums[neg] < 0) neg += 2;
            else {
                int temp = nums[pos];
                nums[pos] = nums[neg];
                nums[neg] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Level2 l = new Level2();
        int[] nums = {1, 0, 1, 2, -1, -4};
        int[] nums1 = {9, 12, 5, 10, 14, 3, 10};
        List<List<Integer>> ans1 = new ArrayList<>();
        int[] arr = new int[nums1.length];
        arr = l.pivotArray(nums1, 10);
        printArrayMethod(arr);
        System.out.println();
        ans1 = l.threeSum(nums);
        System.out.println(ans1);
        int[] nums2 = {3, 1, -2, -5, 2, -4};
        int[] arr2 = l.rearrangeArray(nums2);
        printArrayMethod(arr2);
        System.out.println();
    }
}
