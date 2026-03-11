package Recursion;

import java.security.PublicKey;

public class DigitalRoot {
    int sumOfDigit(int n){
        if(n<10){
            return n;
        }
        int digit=n%10;
        return digit+sumOfDigit(n/10);
    }
    int AllNum(int n){
       int ans= sumOfDigit(n);
       while(ans>10){
           ans=sumOfDigit(ans);
       }
       return ans;
    }
    public static void main(String[] args){
        DigitalRoot d=new DigitalRoot();
        int ans=d.sumOfDigit(9999);
        System.out.println(ans);
        int ans2=d.AllNum(9999);
        System.out.println(ans2);
    }
}
