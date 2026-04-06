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
    int stairCaseTab(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    int stairCaseSpace(int n){
        if(n<=1){
            return 1;
        }
        int prev2=1;
        int prev1=1;
        for (int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        Practice p = new Practice();
        int n = 3;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(" ways Avilable " + p.stairCase(n, dp));
        System.out.println(" ways Avilable " + p.stairCaseTab(n));
        System.out.println(" ways Avlanle "+ p.stairCaseSpace(n));

    }
}
