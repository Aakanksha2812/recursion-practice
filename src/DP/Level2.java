package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Level2 {
    boolean subsetSum(int i, int target, ArrayList<Integer> list, int[][] dp) {
        if (i == list.size()) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        if (dp[i][target] != -1) {
            if (dp[i][target] == 1) {
                return true;
            }
            return false;
        }
        boolean pick = false;
        if (list.get(i) <= target) {
            pick = subsetSum(i + 1, target - list.get(i), list, dp);
        }
        boolean nonPick = subsetSum(i + 1, target, list, dp);
        if (pick || nonPick) {
            dp[i][target] = 1;
        } else {
            dp[i][target] = 0;
        }
        return pick || nonPick;

    }

    int perfectSquare(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (i * i <= n) {
                min = Math.min(min, perfectSquare(n - i * i, dp));
            }
        }
        dp[n] = min + 1;
        return dp[n];
    }

    /*int coinChange(int[] coins, int amount, int[] dp) {
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != -1) {
            return dp[amount];
        }
        if(amount<0 || amount)
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                min = Math.min(min, coinChange(coins, amount - coins[i], dp));
            }
        }
        dp[amount] = min + 1;
        return dp[amount];
    }*/
    int minStepsToZero(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(min, minStepsToZero(n - 1, dp));
        if (n - 3 >= 0) {
            min = Math.min(min, minStepsToZero(n - 3, dp));
        }
        if (n - 4 >= 0) {
            min = Math.min(min, minStepsToZero(n - 4, dp));
        }
        dp[n] = min + 1;
        return dp[n];
    }

    int maxSumNonAdj(int n, int[] num, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int pick = num[n] + maxSumNonAdj(n - 2, num, dp);
        int nonPick = maxSumNonAdj(n - 1, num, dp);
        dp[n] = Math.max(pick, nonPick);
        return dp[n];
    }

    int maxSumConsucative(int i, int prev, int[] num) {
        if (i < 0) {
            return 0;
        }
        int nonPick = maxSumConsucative(i - 1, prev, num);
        int pick = 0;
        if (prev == -1 || num[i] < num[prev]) {
            pick = num[i] + maxSumConsucative(i - 1, i, num);
        }
        return Math.max(pick, nonPick);
    }

    int waysToMakeSum(int[] nums, int target, int[] dp) {
        if (target < 0) {
            return 0;
        }
        if (target == 0) {
            return 0;
        }
        if (dp[target] != -1) {
            return dp[target];
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                count += waysToMakeSum(nums, target - nums[i], dp);
            }
        }
        dp[target] = count;
        return dp[target];
    }

    int countSubsetWithSum(int idx, int[] nums, int target, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (idx >= nums.length || target < 0) {
            return 0;
        }

        if (dp[idx][target] != -1) {
            return dp[idx][target];
        }

        int pick = countSubsetWithSum(idx + 1, nums, target - nums[idx], dp);
        int nonPick = countSubsetWithSum(idx + 1, nums, target, dp);
        dp[idx][target] = pick + nonPick;
        return dp[idx][target];
    }

    int frogJump(int i, int[] heights, int[] dp, int k) {
        if (i == 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {
            if (i - j >= 0) {
                int cost = frogJump(i - j, heights, dp, k) + Math.abs(heights[i] - heights[i - j]);
                min = Math.min(min, cost);
            }

        }
        dp[i] = min;
        return dp[i];
    }

    int minSumPath(int[][] grid, int row, int col, int n, int m) {
        if (col >= m || col < 0 || row >= n || row < 0) {
            return Integer.MAX_VALUE;
        }
        if (row == n - 1) {
            return grid[row][col];
        }
        //   int min=Integer.MAX_VALUE;
        int down = minSumPath(grid, row + 1, col, n, m);
        int downLeft = minSumPath(grid, row + 1, col - 1, n, m);
        int downRight = minSumPath(grid, row + 1, col + 1, n, m);
        int min = Math.min(down, Math.min(downLeft, downRight));
        if (min == Integer.MAX_VALUE) {
            return min;
        }
        return grid[row][col] + min;
    }

    int fromRowminSumPath(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            ans = Math.min(ans, minSumPath(grid, 0, i, grid.length, grid[0].length));
        }
        return ans;
    }

    int waysToDestiny(int i, int j, int n, int m) {
        if (i >= n || j >= m || i < 0 || j < 0) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        int right = waysToDestiny(i, j + 1, n, m);
        int down = waysToDestiny(i + 1, j, n, m);
        return right + down;
    }

    int minCost(int[] cost, int i, int[] dp) {
        if (i >= cost.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        dp[i] = Math.min(cost[i] + minCost(cost, i + 1, dp), cost[i] + minCost(cost, i + 2, dp));
        return dp[i];
    }

    int climbingStairsCountWays(int n, int[] dp) {

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        int step1 = climbingStairsCountWays(n - 1, dp);
        int step2 = climbingStairsCountWays(n - 2, dp);
        dp[n] = step1 + step2;
        return dp[n];
    }

    int minStepsWithK(int[] cost, int k, int idx, int[] dp) {
        if (idx >= cost.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int min = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 1; i <= k; i++) {
            if (idx + i < cost.length) {
                found = true;
                min = Math.min(min, cost[idx] + minStepsWithK(cost, k, idx + i, dp));
            }
        }
        if (!found) {
            return cost[idx];
        }
        dp[idx] = min;
        return dp[idx];
    }

    int frogJump(int idx, int[] heights, int[] dp) {
        if (idx == heights.length - 1) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int step1 = Integer.MAX_VALUE, step2 = Integer.MAX_VALUE;
        if (idx + 1 < heights.length) {
            step1 = Math.abs(heights[idx] - heights[idx + 1]) + frogJump(idx + 1, heights, dp);
        }
        if (idx + 2 < heights.length) {
            step2 = Math.abs(heights[idx] - heights[idx + 2]) + frogJump(idx + 2, heights, dp);

        }
        dp[idx] = Math.min(step1, step2);
        return dp[idx];
    }

    int subsetSumR(int i, int[] nums, int target, int[][] dp) {

        if (i >= nums.length) {
            if (target == 0) {
                return 1;
            }
            return 0;
        }

        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        int pick = 0;
        if (nums[i] <= target) {
            pick = subsetSumR(i + 1, nums, target - nums[i], dp);

        }
        int nobpick = subsetSumR(i + 1, nums, target, dp);
        return dp[i][target] = pick + nobpick;
    }

    int countPartitions(int[] nums, int diff) {

        int total = 0;
        for (int num : nums) total += num;


        if ((total + diff) % 2 != 0) return 0;

        int target = (total + diff) / 2;

        int n = nums.length;
        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return subsetSumR(0, nums, target, dp);
    }

    int lis(int i, int prevIndex, int[] arr) {
        if (i >= arr.length) {
            return 0;
        }
        int nottake = lis(i + 1, prevIndex, arr);
        int take = 0;
        if (prevIndex == -1 || arr[i] > arr[prevIndex]) {
            take = 1 + lis(i + 1, i, arr);
        }
        return Math.max(nottake, take);
    }

    public static void main(String[] args) {
        Level2 l = new Level2();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 7, 8, 10));
        int[][] dp = new int[list.size()][12];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(l.subsetSum(0, 11, list, dp));
        int n = 12;
        int[] dp1 = new int[n + 1];
        Arrays.fill(dp1, -1);
        System.out.println("perfect sqaure " + l.perfectSquare(12, dp1));
        int[] coin = new int[]{1, 2, 5};
        int amount = 12;
        int n1 = 7;
        int[] dp2 = new int[n1 + 1];
        Arrays.fill(dp2, -1);
        //  System.out.println(l.coinChange(coin, amount, dp2));
        System.out.println("minimum steps to zero " + l.minStepsToZero(7, dp2));
        int[] num = new int[]{2, 1, 4, 9};
        int[] dp3 = new int[num.length + 1];
        Arrays.fill(dp3, -1);
        System.out.println("maximum sum " + l.maxSumNonAdj(num.length - 1, num, dp3));
        int[] num1 = new int[]{4, 1, 2, 9};
        System.out.println(l.maxSumConsucative(num1.length - 1, -1, num1));
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        int[] dp4 = new int[target + 1];
        Arrays.fill(dp4, -1);
        System.out.println("ways to make sum " + l.waysToMakeSum(nums, target, dp4));
        int[] nums1 = new int[]{1, 2, 3, 3};
        int target1 = 6;
        int[][] dp5 = new int[nums1.length][target1 + 1];
        for (int[] arr : dp5) {
            Arrays.fill(arr, -1);
        }
        System.out.println(l.countSubsetWithSum(0, nums1, target1, dp5));
        int[] heights = new int[]{10, 30, 40, 20};
        int[] dp6 = new int[heights.length];
        Arrays.fill(dp6, -1);
        System.out.println("frog jum for k steps: " + l.frogJump(heights.length - 1, heights, dp6, 3));
        int[][] matrix = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println("minumim path " + l.fromRowminSumPath(matrix));

        System.out.println("ways to reach destiny: " + l.waysToDestiny(0, 0, 2, 2));
        int[] cost = new int[]{10, 15, 20};
        int[] dp7 = new int[cost.length];
        Arrays.fill(dp7, -1);
        System.out.println("minimum cost to reach last index: " + Math.min(l.minCost(cost, 0, dp7), l.minCost(cost, 1, dp7)));
        int[] cost1 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] dp8 = new int[cost1.length];
        Arrays.fill(dp8, -1);
        System.out.println("minimum cost to reach last index: " + l.climbingStairsCountWays(3, dp8));
        int[] cost2 = new int[]{3, 2, 4, 5, 1};
        int[] dp9 = new int[cost2.length];
        Arrays.fill(dp9, -1);
        System.out.println("minimum cost to reach last index: " + l.minStepsWithK(cost2, 2, 0, dp9));
        int[] heights1 = new int[]{10, 20, 30, 10};
        int[] dp10 = new int[heights1.length];
        Arrays.fill(dp10, -1);
        System.out.println("minimum cost of frog jump: " + l.frogJump(0, heights1, dp10));
        int[] nums2 = new int[]{0, 0, 0};
        int target2 = 0;
        int[][] dp11 = new int[nums2.length][target2 + 1];
        for (int[] arr : dp11) {
            Arrays.fill(arr, -1);
        }
        System.out.println("subset of target is present " + l.subsetSumR(0, nums2, target2, dp11));
        System.out.println("subset of target is present " + +l.countPartitions(nums2, 1));

        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("nfbsndfgdfbgdnbng " + l.lis(0, -1, arr));
    }
}
