package DP;

import java.util.Arrays;

public class Basic {

    // Recursion
    int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Memoization
    int fibonacci(int n, int[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
        return dp[n];
    }
    // Tabulation
    int fibonacciTable(int n){
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    // Space optamazation
    int fibonacciSpace(int n){
        if(n<=1){
            return n;
        }
        int prev2=0;
        int prev1=1;
        for (int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Basic b = new Basic();
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Recursion " + b.fibonacci(n));
        System.out.println("Memoization " + b.fibonacci(n, dp));
        System.out.println("Tabulation "+b.fibonacciTable(n));
        System.out.println("space optimization "+b.fibonacciSpace(n));

    }
}
