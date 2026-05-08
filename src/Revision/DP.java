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




    public static void main(String[] args) {
        DP d = new DP();
        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println("maximum amount after robbery: " + d.rob(nums));
        int n = 20;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("minimum square in number: " + d.minSquareNumber(n, dp));
    }
}
