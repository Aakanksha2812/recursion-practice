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
    int stockTransactionK(int i,int canBuy,int k,int[] price,int[][] dp){
        if (k==0 || i>=price.length){
            return 0;
        }
        if (dp[i][canBuy]!=-1){
            return dp[i][canBuy];
        }
        if (canBuy==1){
            dp[i][canBuy]=Math.max(-price[i]+stockTransactionK(i+1,0,k,price,dp),stockTransactionK(i+1,1,k,price,dp));
        }
        else{
            dp[i][canBuy]=Math.max(price[i]+stockTransactionK(i+1,1,k-1,price,dp),stockTransactionK(i+1,0,k,price,dp));
        }
        return dp[i][canBuy];
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
        int[] price1 = new int[]{3,2,6,5,0,3};
        int[][] dp2 = new int[price1.length][2];
        for (int[] arr : dp2) {
            Arrays.fill(arr, -1);
        }
        System.out.println("total profit with K transaction: " + l.stockTransactionK(0,1,2,price1,dp2));
    }
}
