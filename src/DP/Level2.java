package DP;

import java.util.ArrayList;
import java.util.Arrays;

public class Level2 {
    boolean subsetSum(int i, int target, ArrayList<Integer> list, int[][] dp) {
        if (i == list.size()) {
            if (target == 0) {
                return true;
            }
            return false;
        }
        if (dp[i][target] != -1) {
            if (dp[i][target] == 1) {
                return true;
            }
            return false;
        }
        boolean pick = false;
        if (list.get(i) <= target) {
            pick = subsetSum(i + 1, target - list.get(i), list, dp);
        }
        boolean nonPick = subsetSum(i + 1, target, list, dp);
        if (pick || nonPick) {
            dp[i][target] = 1;
        } else {
            dp[i][target] = 0;
        }
        return pick || nonPick;

    }

    public static void main(String[] args) {
        Level2 l = new Level2();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 3, 7, 8, 10));
        int[][] dp = new int[list.size()][12];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(l.subsetSum(0, 11, list, dp));
    }
}
