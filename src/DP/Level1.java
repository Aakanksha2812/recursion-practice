package DP;

import java.util.Arrays;

public class Level1 {
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


    int stairCaseTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    int stairCaseSpace(int n) {
        if (n <= 1) {
            return 1;
        }
        int prev2 = 1;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    int solve(int i, int[] nums, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int pick = nums[i] + solve(i - 2, nums, dp);
        int skip = solve(i - 1, nums, dp);
        dp[i] = Math.max(pick, skip);
        return dp[i];
    }

    int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, nums, dp);
    }

    int robTab(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < l; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[l - 1];
    }

    int robSpace(int[] nums) {
        int l = nums.length;
        if (l == 1) {
            return nums[0];
        }
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < l; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    int nonAdjencentGreaterSum(int[] num) {
        int n = num.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(n - 1, num, dp);
    }

    int solve2(int i, int[] nums, int[] dp) {
        if (i < 0) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int pick = Math.abs(nums[i] - solve2(i - 2, nums, dp));
        int skip = solve2(i - 1, nums, dp);
        dp[i] = Math.min(pick, skip);
        return dp[i];
    }

    int frogJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = solve2(n - 1, nums, dp);
//        for (int i=0;i<dp.length;i++){
//            System.out.print(dp[i]+" ");
//        }
        return ans;
    }

    int minStep(int n, int[] dp) {
        if (n == 1) {
            return 0;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int step = minStep(n - 1, dp);
        if (n % 2 == 0) {
            step = Math.min(step, minStep(n / 2, dp));
        }
        if (n % 3 == 0) {
            step = Math.min(step, minStep(n / 3, dp));
        }
        dp[n] = 1 + step;

        return dp[n];
    }

    int minStepTab(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int step = dp[i - 1];
            if (i % 2 == 0) {
                step = Math.min(step, dp[i / 2]);
            }
            if (i % 3 == 0) {
                step = Math.min(step, dp[i / 3]);
            }
            dp[i] = 1 + step;
        }

        return dp[n];

    }

    int waysToReach(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = waysToReach(n - 1, dp) + waysToReach(n - 2, dp);
        return dp[n];
    }

    int minimumCost(int n, int[] cost, int[] dp) {
        if (n == 0) {
            return cost[0];
        }
        if (n == 1) {
            return cost[1];
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = cost[n] + Math.min(minimumCost(n - 1, cost, dp), minimumCost(n - 2, cost, dp));
        return dp[n];
    }

    int minCost(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(minimumCost(n - 1, cost, dp), minimumCost(n - 2, cost, dp));
    }


    public static void main(String[] args) {
        Level1 p = new Level1();
        int n = 3;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(" ways Avilable " + p.stairCase(n, dp));
        System.out.println(" ways Avilable " + p.stairCaseTab(n));
        System.out.println(" ways Avlanle " + p.stairCaseSpace(n));
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int[] nums1 = new int[]{3, 2, 7, 10};
        System.out.println("Memozation " + p.rob(nums));
        System.out.println("Tabulation " + p.robTab(nums));
        System.out.println("Space Optamazation " + p.robSpace(nums));
        System.out.println(p.nonAdjencentGreaterSum(nums1));
        int[] nums2 = new int[]{10, 20, 30, 10};
        System.out.println("frog jum minimum stps "+p.frogJump(nums2));
        int n1 = 10;
        int[] dp1 = new int[n1 + 1];
        Arrays.fill(dp1, -1);
        System.out.println("Minimum steps to reach " + p.minStep(n1, dp1));
        System.out.println("Minimum steps to reach " + p.minStepTab(n1));
        int n2 = 4;
        int[] dp2 = new int[n2 + 1];
        Arrays.fill(dp2, -1);
        System.out.println("ways to reach N " + p.waysToReach(n2, dp2));
        int[] cost = new int[]{1, 100, 1, 1, 1};
        int[] dp3 = new int[cost.length];
        Arrays.fill(dp3, -1);
        System.out.println("minimum cost to reach " + p.minCost(cost));

    }
}
