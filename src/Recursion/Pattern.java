package Recursion;

import java.util.ArrayList;

public class Pattern {

        ArrayList<Integer> helper(ArrayList<Integer> list, int n, int k){

            if(n<=0){
                int a=n+5;
                list.add(a);
                return helper(list,n+5,k);
            }
            else{
                int a=n-5;
                list.add(a);
                return helper(list,n-5,k);
            }

        }
        public ArrayList<Integer> pattern(int n) {
            // code here
            ArrayList<Integer> list=new ArrayList<>();
            list.add(n);
            if(n<0){
                return list;
            }
            int k=n;
            return helper(list,n,k);

    }
    public static void main(String[] args){
            Pattern p=new Pattern();
            System.out.println(p.pattern(10));
    }
}
