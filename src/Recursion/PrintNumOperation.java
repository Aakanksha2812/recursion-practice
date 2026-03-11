package Recursion;

public class PrintNumOperation {
    int printNumTail(int n) {
        if (n == 0) {
            return n;
        }
        System.out.println(n);
        return printNumTail(n - 1);
    }

    int printNumHead(int n) {
        if (n == 0) {
            return n;
        }
        int result = printNumHead(n - 1);
        System.out.println(n);
        return result;
    }
    int sumOfNum(int n){
        if(n==0){
            return 0;
        }
       int a=n+sumOfNum(n-1);

        System.out.println("this one is call no "+n+" "+a);
        return a;
    }

    public static void main(String[] args) {
        PrintNumOperation p = new PrintNumOperation();
      /*  int ans1 = p.printNumTail(5);
       System.out.println(ans1);
        System.out.println("for head method");
        int ans2 = p.printNumHead(5);
        System.out.println(ans2);*/
        int ans3=p.sumOfNum(5);
        System.out.println(ans3);



    }
}
