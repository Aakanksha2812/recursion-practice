package DP;

import java.util.Arrays;

public class Level4 {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    dp[i] = dp[i] | !dp[i - j];
                }
            }
        }
        return dp[n];
    }

    int staircaseForbidden(int n, int[] forb, int[] dp) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        for (int i = 0; i < forb.length; i++) {
            if (n == forb[i]) {
                return 0;
            }
        }
        dp[n] = staircaseForbidden(n - 1, forb, dp) + staircaseForbidden(n - 2, forb, dp) + staircaseForbidden(n - 3, forb, dp);
        return dp[n];
    }

    boolean palindrome(int s, int e, String str) {
        if (s >=e) {
            return true;
        }
        if (str.charAt(s) != str.charAt(e)) {
            return false;
        }
        return palindrome(s + 1, e - 1, str);
    }

    String palindromicString(int i, String str, String camp) {
        if (i >= str.length()) {
            return camp;
        }
        for (int j = i; j < str.length(); j++) {

                String ans = str.substring(i, j + 1);
                if (palindrome(i, j, str)) {
                    if (camp.length() < ans.length()) {
                        camp = ans;
                    }
                }



        }
        return palindromicString(i + 1, str, camp);
    }

    public static void main(String[] args) {
        Level4 l = new Level4();
        System.out.println("Alice is winner " + l.divisorGame(8));
        int[] frob = new int[]{2};
        int n = 4;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("ways are possible for N " + l.staircaseForbidden(4, frob, dp));
        String string = "babad";
        StringBuilder s = new StringBuilder();
        System.out.println("String is palindrome: " + l.palindromicString(0, string, ""));
    }
}
