package DP;

import java.util.Arrays;

public class Level3 {
    int stockDP(int i, int canBuy, int[] stock, int[][] dp) {
        if (i >= stock.length) {
            return 0;
        }
        if (dp[i][canBuy] != -1) {
            return dp[i][canBuy];
        }
        if (canBuy == 1) {
            dp[i][canBuy] = Math.max(-stock[i] + stockDP(i + 1, 0, stock, dp), stockDP(i + 1, 1, stock, dp));

        } else {
            dp[i][canBuy] = Math.max(stock[i] + stockDP(i + 1, 1, stock, dp), stockDP(i + 1, 0, stock, dp));

        }
        return dp[i][canBuy];
    }

    int stockCoolDown(int i, int canBuy, int[] price, int[][] dp) {
        if (i >= price.length) {
            return 0;
        }
        if (canBuy == 1) {
            dp[i][canBuy] = Math.max(-price[i] + stockCoolDown(i + 1, 0, price, dp), stockCoolDown(i + 1, 1, price, dp));
        } else {
            dp[i][canBuy] = Math.max(price[i] + stockCoolDown(i + 2, 1, price, dp), stockCoolDown(i + 1, 0, price, dp));
        }
        return dp[i][canBuy];
    }

    int stockTransactionK(int i, int canBuy, int k, int[] price, int[][][] dp) {
        if (k == 0 || i >= price.length) {
            return 0;
        }
        if (dp[i][canBuy][k] != -1) {
            return dp[i][canBuy][k];
        }
        if (canBuy == 1) {
            dp[i][canBuy][k] = Math.max(-price[i] + stockTransactionK(i + 1, 0, k, price, dp), stockTransactionK(i + 1, 1, k, price, dp));
        } else {
            dp[i][canBuy][k] = Math.max(price[i] + stockTransactionK(i + 1, 1, k - 1, price, dp), stockTransactionK(i + 1, 0, k, price, dp));
        }
        return dp[i][canBuy][k];
    }

    int minJump(int i, int[] arr, int[] dp) {
        if (i >= arr.length - 1) {
            return 0;
        }
        if (arr[i] == 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 1; j <= arr[i]; j++) {
            int next = minJump(i + j, arr, dp);
            if (next != -1) {
                min = Math.min(min, next + 1);
            }
        }
        return dp[i] = min;
    }

    boolean canReach(int i, int[] arr, int[] dp4) {

        if (i == arr.length - 1) {
            return true;
        }
        if (i >= arr.length || arr[i] == 0) {
            return false;
        }
        if (dp4[i] != -1) {
            return dp4[i] == 1;
        }
        for (int j = 1; j <= arr[i]; j++) {
            if (canReach(i + j, arr, dp4)) {
                dp4[i] = 1;
                return true;
            }
        }
        dp4[i] = 0;
        return false;
    }

    int rob(int i, int[] home, int[] dp) {
        if (i >= home.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int pick = home[i] + rob(i + 2, home, dp);
        int nonpick = rob(i + 1, home, dp);
        return dp[i] = Math.max(pick, nonpick);
    }

    int knapsack(int i, int w, int[] wt, int[] val, int[][] dp) {
        if (w == 0 || i >= wt.length) {
            return 0;
        }
        if (dp[i][w] != -1) {
            return dp[i][w];
        }
        int nonpick = knapsack(i + 1, w, wt, val, dp);
        int pick = 0;
        if (wt[i] <= w) {
            pick = val[i] + knapsack(i + 1, w - wt[i], wt, val, dp);
        }
        dp[i][w] = Math.max(nonpick, pick);
        return dp[i][w];
    }

    int knapsackTab(int[] wt, int[] val, int W) {

        int n = wt.length;
        int[][] dp = new int[n + 1][W + 1];

        // dp[0][w] = 0 (no items → value 0)

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                int nonPick = dp[i - 1][w];

                int pick = 0;
                if (wt[i - 1] <= w) {
                    pick = val[i - 1] + dp[i - 1][w - wt[i - 1]];
                }

                dp[i][w] = Math.max(pick, nonPick);
            }
        }

        return dp[n][W];
    }

    boolean canPartition(int i, int sum, int[] nums, int[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || i >= nums.length) {
            return false;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }
        boolean pick = canPartition(i + 1, sum - nums[i], nums, dp);
        boolean nonpick = canPartition(i + 1, sum, nums, dp);
        dp[i][sum] = pick || nonpick ? 1 : 0;
        return pick || nonpick;

    }

    int coinChange(int i, int amount, int[] coins, int[][] dp) {

        if (amount == 0) {
            return 0;
        }
        if (i >= coins.length || amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int nonPick = coinChange(i + 1, amount, coins, dp);
        int pick = Integer.MAX_VALUE;

        if (coins[i] <= amount) {
            int next = coinChange(i, amount - coins[i], coins, dp);
            if (next != Integer.MAX_VALUE) {
                pick = 1 + next;
            }
        }

        return dp[i][amount] = Math.min(pick, nonPick);
    }

    int coinChangeWays(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || i >= coins.length) {
            return 0;
        }
        if (dp[i][amount] != -1) {
            return dp[i][amount];
        }
        int nonPick = coinChangeWays(i + 1, amount, coins, dp);
        int pick = 0;
        if (coins[i] <= amount) {
            pick = coinChangeWays(i, amount - coins[i], coins, dp);
        }
        return dp[i][amount] = nonPick + pick;
    }

    int minJumpR(int i, int[] jump, int[] dp) {
        if (i == 0 || i == 1) {
            return jump[i];
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int step1 = jump[i] + minJumpR(i - 2, jump, dp);
        int step2 = jump[i] + minJumpR(i - 1, jump, dp);
        return dp[i] = Math.min(step2, step1);
    }

    int jump(int i, int[] nums) {
        if (i == nums.length-1) {
            return 0;
        }
        if(i>=nums.length || nums[i]==0){
            return Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        int next=0;
        for (int j = 1; j <= nums[i]; j++) {
            next = jump(i + j, nums);
            if (next != Integer.MAX_VALUE) {
                next=1+next;
                min = Math.min(min, next);
            }
        }
        return min;
    }


    public static void main(String[] args) {
        Level3 l = new Level3();
        int[] stock = new int[]{7, 1, 5, 3, 6, 4};
        int[][] dp = new int[stock.length][2];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("total profit in transaction: " + l.stockDP(0, 1, stock, dp));
        int[] price = new int[]{1, 2, 3, 0, 2};
        int[][] dp1 = new int[price.length][2];
        for (int[] arr : dp1) {
            Arrays.fill(arr, -1);
        }
        System.out.println("total profit using cooldown: " + l.stockCoolDown(0, 1, price, dp));
        int[] price1 = new int[]{3, 2, 6, 5, 0, 3};
        int k = 2;
        int[][][] dp2 = new int[price1.length][2][k + 1];
        for (int[][] arr : dp2) {
            for (int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }
        System.out.println("total profit with K transaction: " + l.stockTransactionK(0, 1, 2, price1, dp2));
        int[] arr = {2, 3, 1, 1, 4};
        int[] dp3 = new int[arr.length];
        Arrays.fill(dp3, -1);

        int ans = l.minJump(0, arr, dp3);
        int[] dp4 = new int[arr.length];
        Arrays.fill(dp4, -1);

        System.out.println("minimum jumps to reach last index: " + ans);
        System.out.println("possible to reach last index: " + l.canReach(0, arr, dp4));
        int[] rob = new int[]{2, 7, 9, 3, 1};
        int[] dp5 = new int[rob.length];
        Arrays.fill(dp5, -1);

        System.out.println("profit in " + l.rob(0, rob, dp5));
        int[] wt = new int[]{1, 2, 4, 5};
        int[] val = new int[]{5, 4, 8, 6};
        int W = 5;
        int[][] dp6 = new int[wt.length][W + 1];
        for (int[] arr1 : dp6) {
            Arrays.fill(arr1, -1);
        }
        System.out.println("maximum weight: " + l.knapsack(0, W, wt, val, dp6));
        System.out.println("max weight tab version: " + l.knapsackTab(wt, val, W));
        int[] nums = new int[]{1, 5, 11, 5};
        int sum = 0;


        for (int e : nums) {
            sum += e;
        }
        int[][] dp7 = new int[nums.length][sum + 1];
        for (int[] arr3 : dp7) {
            Arrays.fill(arr3, -1);
        }
        if (sum % 2 != 0) {
            System.out.println("equal partition is not possible");
        } else {
            System.out.println("equal pattition is possible " + l.canPartition(0, sum / 2, nums, dp7));
        }
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int[][] dp8 = new int[coins.length][amount + 1];
        for (int[] arr3 : dp8) {
            Arrays.fill(arr3, -1);
        }
        System.out.println("minimum coin to take amount " + l.coinChange(0, amount, coins, dp8));
        int[] coins1 = new int[]{1, 2, 5};
        int amount1 = 5;
        int[][] dp9 = new int[coins1.length][amount1 + 1];
        for (int[] arr3 : dp9) {
            Arrays.fill(arr3, -1);
        }
        System.out.println("ways for coins " + l.coinChangeWays(0, amount1, coins1, dp9));
        int[] cost = new int[]{10, 15, 20};
        int[] dp10 = new int[cost.length];
        Arrays.fill(dp10, -1);

        System.out.println("jggfgxghb " + Math.min(l.minJumpR(cost.length - 1, cost, dp10), l.minJumpR(cost.length - 2, cost, dp10)));
        int[] nums1 = new int[]{2, 3, 1, 1, 4};
        System.out.println("minimum steps to reach last index " + l.jump(0, nums1));
    }
}
