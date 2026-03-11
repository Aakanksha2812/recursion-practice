package Recursion;

public class PowerOfX {
    double help(double x, int i, int n, double ans) {
        if(n==0){
            return 1;
        }
        if (i == n) {
            return ans;
        }
        if (n < 0) {
            x = 1 / x;

            n = -n;
        }
        ans = ans * x;
        System.out.println(i);
        return help(x, i + 1, n, ans);

    }
    public static void main(String[] args) {
        double x=2.00000;
        int n=-20000;
        double ans;
        if (n < 0) {
            ans = 1 / x;
        } else {
            ans = x;
        }
        PowerOfX p=new PowerOfX();
       double ans1=p. help(x, 1, n,ans);
        System.out.println(ans1);
    }
}
