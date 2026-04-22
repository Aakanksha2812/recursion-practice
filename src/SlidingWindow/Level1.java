package SlidingWindow;

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
    public static void main(String[] args){
        Level1 l=new Level1();
        int[] arr=new int[]{2,1,5,1,3,2};
        System.out.println("Subset with maximum value for K length: "+l.maxSubarrayWithKLen(arr,3));
    }
}
