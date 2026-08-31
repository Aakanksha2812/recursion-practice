package TwoPointer;

import java.util.Arrays;

public class Level1 {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length-1 ;
        double avg = 51;
        while (left < right) {
            double a = (double) (nums[left] + nums[right]) /2;
            avg = Math.min(avg, a);
            left++;
            right--;
        }
        return avg;
        /*   int n = nums.length;
        int mid = n / 2;
        double avg = 0;
        if (mid < n) {
            avg = nums[mid - 1] + nums[mid];
        }
        return avg / 2;*/
    }
    public static void main(String[] args){
        Level1 l=new Level1();
        int[] nums={7,8,3,4,15,13,4,1};
        System.out.println("minimum avg double "+l.minimumAverage(nums));
    }
}
