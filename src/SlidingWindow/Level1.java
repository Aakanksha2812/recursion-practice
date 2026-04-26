package SlidingWindow;

import java.util.HashSet;

public class Level1 {
    int maxSubarrayWithKLen (int[] arr,int k){
        int sum=0;
        for (int i=0;i< k;i++){
            sum+=arr[i];
        }
        int max=sum;
        for (int i=k;i<arr.length;i++){
             sum=sum-arr[i-k]+arr[i];
             max=Math.max(sum,max);
        }
        return max;
    }
    int longestSubstring(String s){
        int maxLen=0;
        HashSet<Character> set=new HashSet<>();
        int left=0;
        for (int right=0;right<s.length();right++){
            while (set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
    public static void main(String[] args){
        Level1 l=new Level1();
        int[] arr=new int[]{2,1,5,1,3,2};
        System.out.println("Subset with maximum value for K length: "+l.maxSubarrayWithKLen(arr,3));
        String s="abcabcbb";
        System.out.println("maximum length of longest substring: "+l.longestSubstring(s));
    }
}
