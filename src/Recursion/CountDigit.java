package Recursion;

public class CountDigit {
    static int helper(int n,int count){
        if(n==0){
            return count;
        }
        //   n=n/10;
     //   count=count++;
        return helper(n/10,count+1);
    }
    public static int countDigits(int n) {
        // Code here
        return helper(n,0);
    }
    public static void main(String[] args){
        CountDigit p=new CountDigit();
        System.out.println(p.countDigits(10));
    }
}
