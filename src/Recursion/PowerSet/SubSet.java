package Recursion.PowerSet;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    void help(int i, int n, int[] nums, List<Integer> subSet, List<List<Integer>> list){
        if(n==i){
            list.add(new ArrayList<>(subSet));
            return;
        }

        subSet.add(nums[i]);
        help(i+1,n,nums,subSet,list);

        subSet.remove(subSet.size()-1);
        help(i+1,n,nums,subSet,list);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subSet = new ArrayList<Integer>();
        int n = nums.length;
        help(0, n, nums, subSet,list);
        return list;
    }
    public static void main(String arg[]){
        SubSet s=new SubSet();
        int[] nums=new int[]{3,1,2};
        System.out.println(s.subsets(nums));
    }
}
