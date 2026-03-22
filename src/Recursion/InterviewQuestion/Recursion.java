package Recursion.InterviewQuestion;

import java.util.ArrayList;

public class Recursion {
    boolean validSumSequence(int i, int[] nums, int target) {
        if (nums.length == i) {
            if (target == 0) {
                // System.out.println();
                return true;
            }
            return false;
        }
        if (nums[i] <= target) {
            if (validSumSequence(i + 1, nums, target - nums[i])) {
                return true;
            }
        }
        if (validSumSequence(i + 1, nums, target)) {
            return true;
        }
        return false;
    }
    int countSumSubsequnces(int i,int[] nums,int target){
        if (nums.length == i) {
            if (target == 0) {
                // System.out.println();
                return 1;
            }
            return 0;
        }
        if(target<0){
            return 0;
        }
        int pick=0,notPick=0;
        if (nums[i] <= target) {
            pick=countSumSubsequnces(i+1,nums,target-nums[i]);
        }
        notPick=countSumSubsequnces(i+1,nums,target);
        return pick+notPick;

    }
  int countArrangement(int pos,int n,boolean[] visited){
        if(pos==n+1){
            return 1;
        }
        int ans=0;
      for (int i = 1; i <=n; i++) {
          if (!visited[i-1]) {
              visited[i-1] = true;
              if(!(i%pos==0 || pos%i==0)){
                  visited[i-1]=false;
                  continue;
              }
             ans+= countArrangement(pos+1,n,visited);
              visited[i-1]=false;
          }
      }
      return ans;
  }

    public static void main(String[] args) {
        Recursion r = new Recursion();
        int[] num = new int[]{1, 2, 3};
        System.out.println(r.validSumSequence(0, num, 2));
        System.out.println(r.countSumSubsequnces(0,num,3));
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<ArrayList<Integer>> store=new ArrayList<>();
        int n=3;
        boolean[] visited=new boolean[n];
        System.out.println( "count arrantgemt "+  r.countArrangement(1,n,visited));


    }
}
