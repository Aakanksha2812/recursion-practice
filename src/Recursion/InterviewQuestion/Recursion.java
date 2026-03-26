package Recursion.InterviewQuestion;

import java.util.ArrayList;

import static Recursion.chatGptQuestionPractice.Level2Questions.pallidrome;
import static Recursion.chatGptQuestionPractice.Level2Questions.swap;

public class Recursion {
    boolean validSumSequence(int i, int[] nums, int target) {
        if (nums.length == i) {
            if (target == 0) {
                // System.out.println();
                return true;
            }
            return false;
        }
        if (nums[i] <= target) {
            if (validSumSequence(i + 1, nums, target - nums[i])) {
                return true;
            }
        }
        if (validSumSequence(i + 1, nums, target)) {
            return true;
        }
        return false;
    }

    int countSumSubsequnces(int i, int[] nums, int target) {
        if (nums.length == i) {
            if (target == 0) {
                // System.out.println();
                return 1;
            }
            return 0;
        }
        if (target < 0) {
            return 0;
        }
        int pick = 0, notPick = 0;
        if (nums[i] <= target) {
            pick = countSumSubsequnces(i + 1, nums, target - nums[i]);
        }
        notPick = countSumSubsequnces(i + 1, nums, target);
        return pick + notPick;

    }

    int countArrangement(int pos, int n, boolean[] visited) {
        if (pos == n + 1) {
            return 1;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                if (!(i % pos == 0 || pos % i == 0)) {
                    visited[i - 1] = false;
                    continue;
                }
                ans += countArrangement(pos + 1, n, visited);
                visited[i - 1] = false;
            }
        }
        return ans;
    }

    void letterCasePermutation(int n, StringBuilder sb, ArrayList<String> list, boolean isLetter, char[] letter, char[] digits, boolean[] usedL, boolean[] usedD) {
        if (n == sb.length()) {
            list.add(sb.toString());
            return;
        }
        if (isLetter) {
            for (int i = 0; i < letter.length; i++) {
                if (!usedL[i]) {
                    usedL[i] = true;
                    sb.append(letter[i]);
                    letterCasePermutation(n, sb, list, false, letter, digits, usedL, usedD);
                    sb.deleteCharAt(sb.length() - 1);
                    usedL[i] = false;
                }
            }
        } else {
            for (int i = 0; i < digits.length; i++) {
                if (!usedD[i]) {
                    usedD[i] = true;
                    sb.append(digits[i]);
                    letterCasePermutation(n, sb, list, true, letter, digits, usedL, usedD);
                    sb.deleteCharAt(sb.length() - 1);
                    usedD[i] = false;
                }
            }
        }
    }

    void letterCase(int i, String s, StringBuilder sb, ArrayList<String> list) {
        if (i == s.length()) {
            list.add(sb.toString());
            return;
        }
        if (Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i));
            letterCase(i + 1, s, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            sb.append(Character.toLowerCase(s.charAt(i)));
            letterCase(i + 1, s, sb, list);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(Character.toUpperCase(s.charAt(i)));
            letterCase(i + 1, s, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    void permutation2(int[] nums, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (nums.length == list.size()) {
            store.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            permutation2(nums, visited, list, store);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    void letterCaseOnly(int i, String s, StringBuilder sb, ArrayList<String> list) {
        if (i == s.length()) {
            list.add(sb.toString());
            return;
        }
        sb.append(Character.toLowerCase(s.charAt(i)));
        letterCaseOnly(i + 1, s, sb, list);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(Character.toUpperCase(s.charAt(i)));
        letterCaseOnly(i + 1, s, sb, list);
        sb.deleteCharAt(sb.length() - 1);

    }

    void parityElement(int[] nums, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (nums.length == list.size()) {
            store.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (!list.isEmpty()) {
                int last = list.get(list.size() - 1);
                if ((last % 2 == 0 && nums[i] % 2 == 0) || (last % 2 != 0 && nums[i] % 2 != 0)) {
                    continue;
                }
            }
            visited[i] = true;
            list.add(nums[i]);
            parityElement(nums, visited, list, store);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    void derangement(int[] nums, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (nums.length == list.size()) {
            store.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            int index = list.size();
            if (nums[i] == nums[index]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            derangement(nums, visited, list, store);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    void permutationWithKlength(int[] nums, int[] k, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (!store.isEmpty()) {
            return;
        }
        if (nums.length == list.size()) {
            k[0]--;
            if (k[0] == 0) {
                store.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                permutationWithKlength(nums, k, visited, list, store);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    void permutationWithKLengthList(int[] nums, int k, int target, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (list.size() == k) {
            if (target == 0) {
                store.add(new ArrayList<>(list));
            }
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);
            permutationWithKLengthList(nums, k, target - nums[i], visited, list, store);
            list.remove(list.size() - 1);

            visited[i] = false;

        }
    }

    void adjencntWithNoAbsoluteDiff(int[] nums, boolean[] visited, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (nums.length == list.size()) {
            store.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (!list.isEmpty()) {
                int last = list.get(list.size() - 1);
                if (Math.abs(nums[i] - last) == 1) {
                    continue;
                }
            }
            visited[i] = true;
            list.add(nums[i]);
            adjencntWithNoAbsoluteDiff(nums, visited, list, store);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    void swapAdjacent(String s, ArrayList<String> list) {

        for (int i = 0; i < s.length() - 1; i++) {
            String swapped = swap(s, i, i + 1);
            list.add(swapped);
        }

    }

    void swapAdjacent2(int i, String s, ArrayList<String> list) {

        list.add(s); // store current string

        if (i >= s.length() - 1) {
            return;
        }

        // swap adjacent (i, i+1)
        String swapped = swap(s, i, i + 1);

        swapAdjacent2(i + 1, swapped, list);
    }

    void permutationWithRepationWithKLength(int[] nums, int k, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (k == list.size()) {
            store.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            permutationWithRepationWithKLength(nums, k, list, store);
            list.remove(list.size() - 1);
        }
    }

    void combinationWithRepetationWithKLength(int i, int[] nums, int k, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (i >= nums.length) {
            return;
        }
        if (k == list.size()) {
            store.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        combinationWithRepetationWithKLength(i, nums, k, list, store);
        list.remove(list.size() - 1);
        combinationWithRepetationWithKLength(i + 1, nums, k, list, store);
    }

    void island(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        int[] dx={-1,0,1,0};
        int[] dy={0,1,0,-1};
        for(int d=0;d<4;d++){
            island(grid,i+dx[d],j+dy[d],n,m);
        }
       /* island(grid, i + 1, j, n, m);
        island(grid, i, j + 1, n, m);
        island(grid, i - 1, j, n, m);
        island(grid, i, j - 1, n, m);*/

    }

    int countNumberOfIsland(int[][] grid, int n, int m) {
        int numberOfIsland = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    island(grid, i, j, n, m);
                    numberOfIsland++;
                }
            }
        }
        return numberOfIsland;
    }

    int sizeOfIsland(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int count = 1;
        count += sizeOfIsland(grid, i + 1, j, n, m);
        count += sizeOfIsland(grid, i, j + 1, n, m);
        count += sizeOfIsland(grid, i - 1, j, n, m);
        count += sizeOfIsland(grid, i, j - 1, n, m);
        return count;
    }

    int maxmimumSizeOfIsland(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int size = sizeOfIsland(grid, i, j, n, m);
                  //  System.out.println(size);
                    if (max < size) {
                        max = size;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Recursion r = new Recursion();
        int[] num = new int[]{1, 2, 3};
        System.out.println(r.validSumSequence(0, num, 2));
        System.out.println(r.countSumSubsequnces(0, num, 3));
        ArrayList<String> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> store = new ArrayList<>();
        int n = 3;
        boolean[] visited = new boolean[n];
        System.out.println("count arrantgemt " + r.countArrangement(1, n, visited));
        char[] letter = new char[]{'A', 'B'};
        char[] digits = new char[]{'1', '2'};
        boolean[] usedL = new boolean[2];
        boolean[] usedD = new boolean[2];
        r.letterCasePermutation(4, new StringBuilder(""), list, true, letter, digits, usedL, usedD);
        r.letterCasePermutation(4, new StringBuilder(""), list, false, letter, digits, usedL, usedD);
        System.out.println(list);
        ArrayList<String> list1 = new ArrayList<>();
        r.letterCase(0, "a1b2", new StringBuilder(""), list1);
        System.out.println(list1);
        int[] nums = new int[]{1, 2, 3, 4};
        ArrayList<Integer> list2 = new ArrayList<>();
        boolean[] visited1 = new boolean[nums.length];
        r.permutation2(nums, visited1, list2, store);
        System.out.println(store);
        ArrayList<Integer> list3 = new ArrayList<>();
        boolean[] visited2 = new boolean[nums.length];
        ArrayList<ArrayList<Integer>> store1 = new ArrayList<>();
        int[] k = {3};
        r.permutationWithKlength(nums, k, visited2, list3, store1);
        System.out.println(store1);
        ArrayList<String> list4 = new ArrayList<>();
        r.letterCaseOnly(0, "ab", new StringBuilder(""), list4);
        System.out.println(list4);
        ArrayList<Integer> list5 = new ArrayList<>();
        boolean[] visited3 = new boolean[nums.length];
        ArrayList<ArrayList<Integer>> store2 = new ArrayList<>();
        r.parityElement(nums, visited3, list5, store2);
        System.out.println(store2);
        ArrayList<Integer> list6 = new ArrayList<>();
        boolean[] visited4 = new boolean[nums.length];
        ArrayList<ArrayList<Integer>> store3 = new ArrayList<>();
        r.derangement(nums, visited4, list6, store3);
        System.out.println(store3);
        boolean[] visited5 = new boolean[nums.length];
        ArrayList<ArrayList<Integer>> store4 = new ArrayList<>();
        r.permutationWithKLengthList(nums, 2, 5, visited5, new ArrayList<>(), store4);
        System.out.println(store4);
        ArrayList<ArrayList<Integer>> store5 = new ArrayList<>();
        r.adjencntWithNoAbsoluteDiff(nums, new boolean[nums.length], new ArrayList<>(), store5);
        System.out.println(store5);
        ArrayList<String> list7 = new ArrayList<>();
        r.swapAdjacent("abc", list7);
        System.out.println(list7);
        ArrayList<String> list8 = new ArrayList<>();
        r.swapAdjacent2(0, "abc", list8);
        System.out.println(list8);
        int[] nums2 = new int[]{1, 2, 3};
        ArrayList<ArrayList<Integer>> store6 = new ArrayList<>();
        r.permutationWithRepationWithKLength(nums2, 2, new ArrayList<>(), store6);
        System.out.println(store6);
        ArrayList<ArrayList<Integer>> store7 = new ArrayList<>();
        r.combinationWithRepetationWithKLength(0, nums2, 2, new ArrayList<>(), store7);
        System.out.println(store7);
        int[][] grid = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };
        int[][] grid1 = new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 1, 0}
        };

        boolean[][] visited7 = new boolean[3][3];
        System.out.println(r.countNumberOfIsland(grid, 3, 3));

        System.out.println(r.maxmimumSizeOfIsland(grid1));

    }
}
