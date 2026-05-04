package DP;

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

    public static void main(String[] args) {
        Level4 l = new Level4();
        System.out.println("Alice is winner " + l.divisorGame(8));
    }
}
