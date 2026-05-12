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

    boolean isWordPresentInDictionary(int i, String s, String[] dict) {
        if (i >= s.length()) {
            return true;
        }
        for (int j = i; j < s.length(); j++) {
            String part = s.substring(i, j + 1);
            if (isPresent(part, dict)) {
                if (isWordPresentInDictionary(j + 1, s, dict)) {
                    return true;
                }
            }
        }
        return false;
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
        String[] dict = new String[]{"apple", "pen"};
        System.out.println("is word form string is present in dictionary: " + d.isWordPresentInDictionary(0, "appleptenapple", dict));
    }
}
