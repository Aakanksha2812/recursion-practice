package DP;

import java.util.ArrayList;
import java.util.Arrays;

import static String.Solution2.intToString;
import static String.Solution2.isPresent;

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
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

    String largestCommonSubsequenceString(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        // reconstruct LS
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();

        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                ans.append(s1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] > dp[i][j + 1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toString();

    }

    int largestCommonSubstring(String s1, String s2) {
        int max = 0;
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    String shortestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int max = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s1.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    max = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                ans.append(s1.charAt(i));
                i++;
                j++;
            } else if (dp[i + 1][j] > dp[i][j + 1]) {
                ans.append(s1.charAt(i));
                i++;
            } else {
                ans.append(s2.charAt(j));
                j++;
            }
        }
        while (i < n) {
            ans.append(s1.charAt(i));
            i++;
        }
        while (j < m) {
            ans.append(s2.charAt(j));
            j++;
        }
        return ans.toString();
    }

    void subString(int i, String s, StringBuilder str, ArrayList<String> list) {
        if (i >= s.length()) {

            list.add(str.toString());
            return;
        }
        str.append(s.charAt(i));
        subString(i + 1, s, str, list);
        str.deleteCharAt(str.length() - 1);
        subString(i + 1, s, str, list);

    }

    boolean isWordPresentInDictionary(int i, String s, String[] dict, int[] dp) {
        if (i >= s.length()) {
            return true;
        }
        if (dp[i] != -1) {
            return dp[i] == 1;
        }

        for (int j = i; j < s.length(); j++) {
            String part = s.substring(i, j + 1);
            if (isPresent(part, dict)) {
                if (isWordPresentInDictionary(j + 1, s, dict, dp)) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = 0;
        return false;
    }

    int minExtraChar(int i, String s, String[] dict, int[] dp) {
        if (i >= s.length()) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int ans = 1 + minExtraChar(i + 1, s, dict, dp);
        for (int j = i; j < s.length(); j++) {
            String part = s.substring(i, j + 1);
            if (isPresent(part, dict)) {
                ans = Math.min(ans, minExtraChar(j + 1, s, dict, dp));

            }
        }


        return dp[i] = ans;
    }

    int palindromicSubsequence(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;

        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int k = j + i - 1;
                if (s.charAt(k) == s.charAt(j)) {
                    dp[j][k] = dp[j + 1][k - 1] + 2;
                } else {
                    dp[j][k] = Math.max(dp[j][k - 1], dp[j + 1][k]);
                }
            }

        }
        return dp[0][n - 1];
    }

    int deletionOfExtraLPS(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int k = i + j - 1;
                if (s.charAt(j) == s.charAt(k)) {
                    dp[j][k] = dp[j + 1][k - 1] + 2;
                } else {
                    dp[j][k] = Math.max(dp[j + 1][k], dp[j][k - 1]);
                }
            }

        }
        return n - dp[0][n - 1];
    }

    int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        int max =dp[0][0] ;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        StringDP d = new StringDP();
        String s1 = "abac";
        String s2 = "cab";
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println("Longest Common Subsequence: " + d.largestCommonSubsequences(0, 0, s1, s2, dp));
        System.out.println("Longest Common Subsequence: " + d.largestCommonSubsequencesTab(s1, s2));
        System.out.println("Longest Common Subsequence: " + d.largestCommonSubsequenceString(s1, s2));

        String s3 = "abcde";
        String s4 = "abdce";
        System.out.println("Longest Common Substring: " + d.largestCommonSubstring(s3, s4));
        System.out.println("Shortest common supersequnce: " + d.shortestCommonSubsequence(s1, s2));
        ArrayList<String> list = new ArrayList<>();
        d.subString(0, "leetscode", new StringBuilder(), list);
        System.out.println(list);
        String[] dict = new String[]{"leet", "code"};
        String s = "leetscode";
        int[] dp1 = new int[s.length()];
        Arrays.fill(dp1, -1);
        System.out.println("is word form string is present in dictionary: " + d.isWordPresentInDictionary(0, s, dict, dp1));
        int[] dp2 = new int[s.length()];
        Arrays.fill(dp2, -1);
        System.out.println("minimum extra charcater present in string: " + d.minExtraChar(0, s, dict, dp2));
        String str = "aebcbda";
        System.out.println("maximum palindromic subsquence: " + d.palindromicSubsequence(str));
        System.out.println("number of character deletion from string: " + d.deletionOfExtraLPS(str));
        System.out.println("common subsequence between str1 and str2: "+d.lcs("abcde","ace"));

    }
}
