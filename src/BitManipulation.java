public class BitManipulation {
    int differntNumber(int[] nums){
        int ans=0;
        for (int n:nums){
            ans^=n;
        }
        return ans;
    }
    public static void main(String[] args){
        BitManipulation b=new BitManipulation();
        int[] num=new int[]{1,2,1,4,2,9};
        System.out.println(b.differntNumber(num));
    }
}
