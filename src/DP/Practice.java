package DP;

import java.util.Arrays;

public class Practice {
    int stairCase(int n, int[] dp) {
        if (n <= 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = stairCase(n - 1, dp) + stairCase(n - 2, dp);
        return dp[n];
    }

    int stairCaseTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    int stairCaseSpace(int n) {
        if (n <= 1) {
            return 1;
        }
        int prev2 = 1;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    int solve(int i, int[] nums, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int pick = nums[i] + solve(i - 2, nums, dp);
        int skip = solve(i - 1, nums, dp);
        dp[i] = Math.max(pick, skip);
        return dp[i];
    }

    int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, nums, dp);
    }

    public static void main(String[] args) {
        Practice p = new Practice();
        int n = 3;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(" ways Avilable " + p.stairCase(n, dp));
        System.out.println(" ways Avilable " + p.stairCaseTab(n));
        System.out.println(" ways Avlanle " + p.stairCaseSpace(n));
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(p.rob(nums));

    }
}
