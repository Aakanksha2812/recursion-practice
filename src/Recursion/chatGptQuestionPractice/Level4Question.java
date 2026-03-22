package Recursion.chatGptQuestionPractice;

import java.util.ArrayList;
import java.util.Arrays;

import static Recursion.chatGptQuestionPractice.Level2Questions.pallidrome;

public class Level4Question {
    void permutationOfString(String s, StringBuilder sb, boolean[] freq, ArrayList<String> list) {
        if (s.length() == sb.length()) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!freq[i]) {
                freq[i] = true;
                sb.append(s.charAt(i));
                permutationOfString(s, sb, freq, list);
                sb.deleteCharAt(sb.length() - 1);
                freq[i] = false;
            }
        }
    }

    void subSetSum(int i, int[] num, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (i == num.length) {
            if (target == 0) {
                store.add(new ArrayList<>(list));
            }
            return;
        }
        if (num[i] <= target) {
            list.add(num[i]);
            subSetSum(i + 1, num, target - num[i], list, store);
            list.remove(list.size() - 1);
        }
        // list.add()
        subSetSum(i + 1, num, target, list, store);
    }

    int maximumLengthForSum(int i, int[] num, int k, int length) {
        if (k < 0) {
            return 0;
        }
        if (i == num.length) {
            return length;

        }

        int take = maximumLengthForSum(i + 1, num, k - num[i], length + 1);

        int nottake = maximumLengthForSum(i + 1, num, k, length);
        return Math.max(take, nottake);
    }

    int maximumLengthForExactSum(int i, int[] num, int k, int length) {
        if (k < 0) {
            return Integer.MIN_VALUE;
        }
        if (i == num.length) {
            if (k == 0) {
                return length;
            }
            return Integer.MIN_VALUE;
        }
        int take = maximumLengthForExactSum(i + 1, num, k - num[i], length + 1);
        int nonTake = maximumLengthForExactSum(i + 1, num, k, length);
        return Math.max(take, nonTake);
    }

    int countSubsetWithextactSum(int i, int[] num, int k) {
        if (k < 0) {
            return 0;
        }
        if (i == num.length) {
            if (k == 0) {
                return 1;
            }
            return 0;
        }
        int take = countSubsetWithextactSum(i + 1, num, k - num[i]);
        int nontake = countSubsetWithextactSum(i + 1, num, k);
        return take + nontake;
    }

    void combinationSum2(int i, int[] num, int k, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (k == 0) {
            store.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < num.length; j++) {
            if (num[j] > k) {
                break;
            }
            if (j > i && num[j] == num[j - 1]) {
                continue;
            }

            list.add(num[j]);
            combinationSum2(j + 1, num, k - num[j], list, store);
            list.remove(list.size() - 1);

        }
    }

    void permutation2(int[] num, boolean[] freq, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (num.length == list.size()) {
            store.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (freq[i]) {
                continue;
            }
            if (i > 0 && num[i] == num[i - 1] && !freq[i - 1]) {
                continue;
            }
            freq[i] = true;
            list.add(num[i]);
            permutation2(num, freq, list, store);
            list.remove(list.size() - 1);
            freq[i] = false;
        }
    }

    void pallidromePartition(int i, String s, ArrayList<String> list, ArrayList<ArrayList<String>> store) {
        if (i == s.length()) {
            store.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (pallidrome(s, i, j)) {
                String part = s.substring(i, j + 1);
                list.add(part);
                pallidromePartition(j + 1, s, list, store);
                list.remove(list.size() - 1);
            }
        }
    }

    void permutationForFirstTwoelement(int[] nums, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {

        if (nums.length == list.size()) {
            store.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                if (list.size()>1  && ((list.get(list.size()-1) + list.get(list.size()-2)) % 2 != 0)) {
                    list.remove(list.size() - 1);
                    visited[i] = false;
                  continue;
                }
                permutationForFirstTwoelement(nums, visited, list, store);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("SHREE SWAMI SAMARTH");
        Level4Question l = new Level4Question();
        ArrayList<String> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> store = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        int[] num = new int[]{1, 3, 4, 2, 1, 5};
        String s = "ABC";
        boolean[] freq = new boolean[s.length()];
        l.permutationOfString(s, new StringBuilder(""), freq, list);
        System.out.println(list);
        l.subSetSum(0, num, 7, list1, store);
        System.out.println(store);
        int[] num1 = new int[]{2, 3, 5, 6, 8, 10};
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> Store = new ArrayList<>();
        System.out.println(l.maximumLengthForSum(0, num1, 6, 0));
        //   System.out.println(Store);
        System.out.println(l.maximumLengthForExactSum(0, num1, 10, 0));
        System.out.println(l.countSubsetWithextactSum(0, num1, 10));
        int[] num2 = new int[]{10, 1, 2, 7, 6, 1, 5};
        boolean[] freq2 = new boolean[3];
        Arrays.sort(num2);
        l.combinationSum2(0, num2, 8, list2, Store);
        System.out.println(Store);
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> Store1 = new ArrayList<>();
        int[] num3 = new int[]{1, 1, 2};
        l.permutation2(num3, freq2, list3, Store1);
        System.out.println(Store1);
        ArrayList<ArrayList<String>> Store2 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();
        l.pallidromePartition(0, "aab", list4, Store2);
        System.out.println(Store2);
        int[] num4 = new int[]{1, 5, 3};
        ArrayList<Integer> list5 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> Store3 = new ArrayList<>();
        boolean[] visited = new boolean[num4.length];
        l.permutationForFirstTwoelement(num4, visited, list5, Store3);
        System.out.println(Store3);
    }
}
