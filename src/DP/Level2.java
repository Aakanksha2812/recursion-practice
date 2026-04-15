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
    int minStepsToZero(int n,int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int min=Integer.MAX_VALUE;
        min = Math.min(min, minStepsToZero(n - 1,dp));
        if (n - 3 >=0) {
            min = Math.min(min, minStepsToZero(n - 3,dp));
        }
        if (n - 4 >= 0) {
            min = Math.min(min, minStepsToZero(n - 4,dp));
        }
dp[n]=min+1;
        return dp[n];
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
        int n1=7;
        int[] dp2 = new int[n1 + 1];
        Arrays.fill(dp2, -1);
        //  System.out.println(l.coinChange(coin, amount, dp2));
        System.out.println("minimum steps to zero " + l.minStepsToZero(7,dp2));
    }
}
