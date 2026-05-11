package Revision;

import java.util.Arrays;

public class DP {
    public int rob(int[] nums) {
        /* int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return Math.max(solve(0,nums,dp),solve(1,nums,dp));*/

        int n = nums.length;
        if (n < 2) {
            return nums[0];
        }
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = nums[1];
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = nums[i] + dp[i - 2];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    int minSquareNumber(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= n; i++) {
            int step = 1 + minSquareNumber(n - (i * i), dp);
            min = Math.min(step, min);

        }
        dp[n] = min;
        return min;
    }

    int coinChange(int i, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (i >= coins.length || amount < 0) {
            return Integer.MAX_VALUE ;
        }

        int nonPick = coinChange(i + 1, coins, amount);
        int pick = Integer.MAX_VALUE;
        if (coins[i] <= amount) {
          int   next = coinChange(i, coins, amount - coins[i]);
          if (next!=Integer.MAX_VALUE){
              pick=1+next;
          }
        }
        return Math.min(pick, nonPick);
    }


    public static void main(String[] args) {
        DP d = new DP();
        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println("maximum amount after robbery: " + d.rob(nums));
        int n = 20;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("minimum square in number: " + d.minSquareNumber(n, dp));
        int[] coins = new int[]{1, 2, 5};
        System.out.println("minimum coins required for amount: " + d.coinChange(0, coins, 11));
    }
}
