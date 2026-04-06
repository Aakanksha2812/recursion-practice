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

    public static void main(String[] args) {
        Practice p = new Practice();
        int n = 3;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(" ways Avilable " + p.stairCase(n, dp));

    }
}
