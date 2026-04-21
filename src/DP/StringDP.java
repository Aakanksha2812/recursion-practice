package DP;

import java.util.Arrays;

public class StringDP {
    int largestCommonSubsequences(int i, int j, String s1, String s2, int[][] dp) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + largestCommonSubsequences(i + 1, j + 1, s1, s2, dp);
        } else {
            dp[i][j] = Math.max(largestCommonSubsequences(i + 1, j, s1, s2, dp), largestCommonSubsequences(i, j + 1, s1, s2, dp));
        }
        return dp[i][j];
    }

    int largestCommonSubsequencesTab(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for (int i=n-1;i>=0;i--){
            for (int j=m-1;j>=0;j--){
                if (s1.charAt(i)==s2.charAt(j)){
                    dp[i][j]=1+dp[i+1][j+1];
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        StringDP d = new StringDP();
        String s1 = "abcde";
        String s2 = "ace";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Longest Common Subsequence: " + d.largestCommonSubsequences(0, 0, s1, s2, dp));
        System.out.println("Longest Common Subsequence: " + d.largestCommonSubsequencesTab( s1, s2));

    }
}
