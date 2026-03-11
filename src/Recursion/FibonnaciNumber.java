package Recursion;

public class FibonnaciNumber {
    int fibboNumber(int i,int sum){
        if(i==0){
            return 0;
        }
        if(i==1){
            return 1;
        }
      // int ans=fibboNumber(i-1)+fibboNumber(i-2);
        //System.out.println(ans);
        sum=fibboNumber(i-1,sum)+fibboNumber(i-2,sum);
        System.out.println(sum);
        return sum;
    }
    public static void main(String[] args){
        FibonnaciNumber f=new FibonnaciNumber();
        System.out.println(f.fibboNumber(5,0));
    }
}
