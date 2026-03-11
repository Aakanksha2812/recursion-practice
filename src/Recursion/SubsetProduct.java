package Recursion;

import java.util.ArrayList;

public class SubsetProduct {

        void product(int i, int[] nums, long target, long prod, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
            if (i == nums.length) {
                if (target == 1) {
                    store.add(new ArrayList<Integer>(list));
                }
                return;
            }
            prod = prod * nums[i];
            list.add(nums[i]);
            product(i + 1, nums, target / nums[i], prod, list,store);
            prod = prod / nums[i];
            list.remove(list.size() - 1);
            product(i + 1, nums, target, prod, list,store);
        }

        public static void main(String[] args) {
            SubsetProduct s=new SubsetProduct();
            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<ArrayList<Integer>> store=new ArrayList<>();
            int[] nums=new int[]{3,1,6,8,4};
            int target=24;
            int c=0;
           s.product(0, nums, target, 1, list,store);
            System.out.println(store);
            for(int i=0;i<store.size();i++){
                for(int j=0;j<store.get(i).size();j++){
                    c++;
                }
            }
            if(c==nums.length){
                System.out.println(true);
            }
            System.out.println( false);


    }
}
