package Recursion;

import java.util.ArrayList;

class RecamanSequence {
    static int help1(int n ) {
        if (n == 0) {
            return 0;
        }
     return help1(n-1)-n;
    }
    static int help2(int n ) {
        if (n == 0) {
            return 0;
        }
        return help1(n-1)+n;
    }

    static ArrayList<Integer> recamanSequence(int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
      for(int i=1;i<n;i++){
          int a=help1(i);
          if(a<0 || list.contains(a)){
              list.add(help2(i));
          }
          else{
              list.add(a);
          }
      }
        return list;
    }

    public static void main(String[] args) {
        RecamanSequence r = new RecamanSequence();
        System.out.println(r.recamanSequence(5));
    }
}