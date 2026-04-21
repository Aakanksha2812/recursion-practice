package DP;

import java.lang.reflect.Array;
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

    public static void main(String[] args) {
        StringDP d = new StringDP();
        String s1 = "abcde";
        String s2 = "ace";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Longest Common Subsequence: " + d.largestCommonSubsequences(0, 0, s1, s2, dp));
    }
}
