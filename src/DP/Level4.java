package DP;

import java.util.Arrays;

import static Print.PrintFunction.printArrayMethod;

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
        if (s >= e) {
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

    int solve(int i, int j, int n, int m, int[][] obstacleGrid, int[][] dp) {
        if (i >= n || j >= m) {
            return 0;
        }
        if (obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int right = solve(i + 1, j, n, m, obstacleGrid, dp);
        int down = solve(i, j + 1, n, m, obstacleGrid, dp);
        return dp[i][j] = right + down;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        return solve(0, 0, n, m, obstacleGrid, dp);
    }

    int minimumFallingPath(int i, int j, int n, int m, int[][] grid) {
        if (j >= m || j < 0) {
            return Integer.MAX_VALUE / 2;
        }
        if (i == n - 1) {
            return grid[i][j];
        }
        int down = grid[i][j] + minimumFallingPath(i + 1, j, n, m, grid);
        int leftDown = grid[i][j] + minimumFallingPath(i + 1, j - 1, n, m, grid);
        int rightDown = grid[i][j] + minimumFallingPath(i + 1, j + 1, n, m, grid);
        return Math.min(down, Math.min(leftDown, rightDown));
    }

    int maxConsecutiveNumber(int i, int[] nums, int max, int current) {
        if (i >= nums.length) {
            return max;
        }

        if (nums[i] == 1) {
            current++;
            max = Math.max(current, max);
        } else {

            current = 0;
        }
        return maxConsecutiveNumber(i + 1, nums, max, current);
    }

    int maxConsecutiveNumberRow(int[][] grid) {
        int max = 0;
        int index = -1;
        int ix = 0;
        for (int[] arr : grid) {

            index++;
            int ans = maxConsecutiveNumber(0, arr, 0, 0);
            if (ans >= max) {
                max = ans;
                ix = index;
            }
        }
        return ix;
    }

    int maxConsecutiveNumberColumn(int i, int j, int[][] grid, int max, int current) {
        if (i >= grid.length) {
            return max;
        }
        if (grid[i][j] == 1) {
            current++;
            max = Math.max(max, current);
        } else {
            current = 0;
        }
        return maxConsecutiveNumberColumn(i + 1, j, grid, max, current);
    }

    int consecutive1s(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                    }
                }
                max = Math.max(max, dp[i][j]);


            }
        }

        return max * max;
    }

    int solve(int i, int[] nums, int max, int current, int[] dp) {
        if (i >= nums.length) {
            return max;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        current *= nums[i];
        if (max < current) {
            max = current;
            max = Math.max(max, current);
        } else {
            current = 1;
        }
        return dp[i] = solve(i + 1, nums, max, current, dp);
    }

    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return solve(0, nums, Integer.MIN_VALUE, 1, dp);
    }

    int findTargetSumWays(int i, int sum, int[] nums, int target) {
        if (target == sum) {
            return 1;
        }
        if (i >= nums.length) {
            return 0;
        }

        int positive = findTargetSumWays(i + 1, sum + nums[i], nums, target);
        int negative = findTargetSumWays(i + 1, sum - nums[i], nums, target);
        return positive + negative;
    }

    int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    int maxJumpToReachLast(int i, int[] jumps,int target,int[] dp) {
        if (i>=jumps.length){
            return Integer.MIN_VALUE;
        }
        if(i==jumps.length-1){
            return 0;
        }
        if (dp[i]!=-1){
            return dp[i];
        }
      int max=Integer.MIN_VALUE;
        for (int j = i+1; j < jumps.length; j++) {
            int next=0;
            if (Math.abs(jumps[i]-jumps[j])<=target){
                next=maxJumpToReachLast(j,jumps,target,dp);
                if (next!=Integer.MIN_VALUE){
                    max=Math.max(max,1+next);
                }
            }
            max=Math.max(max,next);
        }
        return dp[i]= max;
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
        int[][] matrix = new int[][]{
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        // System.out.println("minimum falling path: "+l.minimumFallingPath(0));
        int min = Integer.MAX_VALUE;
        int n1 = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < m; i++) {
            min = Math.min(min, l.minimumFallingPath(0, i, n1, m, matrix));
        }
        System.out.println("minimum falling path: " + min);
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1, -1);
        int[][] grid = new int[][]{{1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}};
        System.out.println("maximum consecutive number: " + l.maxConsecutiveNumber(0, nums, Integer.MIN_VALUE, 0));
        System.out.println("maximum consecutive in row:  " + l.maxConsecutiveNumberRow(grid));
        int[][] grid1 = new int[][]{
                {1},
                {1},
                {0},
                {1},
                {1},
                {1}
        };
        System.out.println("maximum consecutive in coloum: " + l.maxConsecutiveNumberColumn(0, 0, grid1, 0, 0));
        int[][] grid2 = new int[][]{
                {1, 0, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
        System.out.println("maximum square " + l.consecutive1s(grid2));
        int[] nums1 = new int[]{0, 2};
        System.out.println("maximum product for subarray " + l.maxProduct(nums1));
        int[] nums2 = new int[]{1, 1, 1, 1};
        System.out.println("number of ways to target by using +ve and -ve opration: " + l.findTargetSumWays(0, 0, nums2, 3));
        System.out.println("minimum square present in number: " + l.numSquares(12));
        int[] jumps=new int[]{1,3,6,4,1,2};
        int[] dp2=new int[jumps.length];
        Arrays.fill(dp2,-1);
        System.out.println("maximum jumps to reach last index with target: "+l.maxJumpToReachLast(0,jumps,2,dp2));
    }
}
