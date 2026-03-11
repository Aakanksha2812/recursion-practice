package Recursion;

import java.util.ArrayList;
import java.util.List;

public class JuggleSequence {
    static long help(long n){
        if(n%2==0){
            return (long) Math.pow(n,0.5);
        }
        else{
            return (long) Math.pow(n,1.5);
        }
    }
    static List<Long> jugglerSequence(long n) {
        // code here
        List<Long> list=new ArrayList<>();
        list.add(n);
        while(n!=1){
            long ans=help(n);
            System.out.println(ans);
            list.add(ans);
            n=ans;
        }

return list;
    }
    public static void main(String[] args){
        JuggleSequence j=new JuggleSequence();
        System.out.println(j.jugglerSequence(9));
    }
}
