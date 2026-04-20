package Collection;

import java.util.*;

import static Print.PrintFunction.printArrayMethod;
import static Print.PrintFunction.printHashMapMethod;

public class HashMapPractice {
    int[] twoSum(ArrayList<Integer> list, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int sum = target - list.get(i);
            if (map.containsKey(sum)) {
                return new int[]{map.get(sum), i};
            }
            map.put(list.get(i), i);
        }
        return new int[]{};
    }

    int frequencyOfElement(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : list) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) == 1) {
                return list.get(i);
            }
        }
        return -1;

    }

    boolean identicalList(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (list2.size() != list1.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), map.getOrDefault(list1.get(i), 0) + 1);

        }

        for (int i = 0; i < list2.size(); i++) {
            if (!map.containsKey(list2.get(i))) {
                return false;
            }
            map.put(list2.get(i), map.get(list2.get(i)) - 1);
        }
        for (int val : map.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;

    }

    int largestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currnt = num;
                int count = 0;
                count = 1;
                while (set.contains(currnt + 1)) {
                    currnt++;
                    count++;
                }
                maxLen = Math.max(count, currnt);
            }
        }
        return maxLen;
    }

    int prefixSum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (sum == k) {
                count++;
            }
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    int countSubArrayWithSum(int[] arr, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : arr) {
            sum += e;
            if (sum == k) {
                count++;
            }
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    int countSubArrayWithZero(int[] arr) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int e : arr) {
            sum += e;

            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    int longestEqual01(int[] arr) {
        int maxlen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                sum += 1;
            } else {
                sum += -1;
            }
            if (sum == 0) {
                maxlen = i + 1;
            }
            if (map.containsKey(sum)) {
                int len = map.get(sum);
                maxlen = Math.max(len, maxlen);
            } else {
                map.put(sum, i);
            }
        }
        return maxlen;
    }

    int nonRepeating(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : arr) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        for (int e : arr) {
            if (map.get(e) == 1) {
                return e;
            }
        }
        return -1;
    }

    int majorityElement(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : arr) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        int n = arr.length / 2;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > n ) {
                return e.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        HashMapPractice hm = new HashMapPractice();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 7, 11, 15));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2, 3, 4, 3, 2));
        int[] ans = hm.twoSum(list, 9);
        printArrayMethod(ans);
        System.out.println();
        System.out.println("first non repeating elemnet " + hm.frequencyOfElement(list1));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(2, 7, 11, 15));
        ArrayList<Integer> list3 = new ArrayList<>(Arrays.asList(2, 11, 15, 7));
        System.out.println("list are identical " + hm.identicalList(list2, list3));
        int[] nums2 = new int[]{100, 1, 200, 2, 3, 4};
        System.out.println(hm.largestConsecutive(nums2));
        int[] nums3 = new int[]{1, 1, 1};
        System.out.println(hm.prefixSum(nums3, 2));
        int[] arr = new int[]{1, 2, 1};
        int[] arr1 = new int[]{1, -1, 2, -2, 3};
        System.out.println("subarray with sum k: " + hm.countSubArrayWithSum(arr, 3));
        System.out.println("subarray with sum k: " + hm.countSubArrayWithZero(arr1));
        int[] arr2 = new int[]{1, 0, 1, 1, 0, 0};
        System.out.println("length of 1 and 0 :" + hm.longestEqual01(arr2));
        int[] arr3 = new int[]{4, 5, 1, 2, 0, 4};
        System.out.println("first non repeating element: " + hm.nonRepeating(arr3));
        int[] arr4 = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println("majority of element: " + hm.majorityElement(arr4));


    }


}
