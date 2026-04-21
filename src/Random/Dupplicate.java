package Random;/*import java.util.HashMap;

public class Dupplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){

            if(map.containsValue(nums[i])){
                int idx=map.getkey(nums[i]);
                System.out.println("idx "+idx);
                if(Math.abs(idx-i)<=k){
                    return true;
                }
            }
            map.put(i,nums[i]);
            System.out.println(map);
        }
        return false;
    }
    public static void main(String[] args){
        Dupplicate d=new Dupplicate();
        int[] nums=new int[]{1,2,3,1,2,3};
        System.out.println( d.containsNearbyDuplicate(nums,2));

    }
}*/
