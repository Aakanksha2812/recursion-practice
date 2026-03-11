import java.util.Arrays;

public class digitSumEven{
public int countEven(int num) {
    int count=0;
    for(int i=1;i<=num;i++){
        int a=i%9;
      //  System.out.println("i= "+i +"  "+"a= "+a);
        if(a%2==0){
            count++;
        }
        System.out.println("i= "+i +"  a= "+a+"  Count="+count);
    }
    return count;
}
    public int maxProduct(int n) {
        String s=String.valueOf(n);
        char[] c=s.toCharArray();
        Arrays.sort(c);
        System.out.println(c);
        int i=c.length;
        System.out.println(c[i-1]);
        System.out.println(c[i-2]);
        int a=(c[i-1]-'0')*(c[i-2]-'0');
        return a;
    }
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<=2){
            return false;
        }
        for(int i=2;i<arr.length;i++){
            System.out.println("array "+arr[i]%2);
            if(arr[i]%2!=0 && arr[i-1]%2!=0 && arr[i-2]%2!=0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args)
{
    int n=124;
    digitSumEven d=new digitSumEven();
  //  int ans=d.countEven(n);
    int[] nums=new int[]{2,6,4,1};
   // int ans2=d.maxProduct(n);
    System.out.println("three   "+d.threeConsecutiveOdds(nums));
   // System.out.println(ans2);
}
}
