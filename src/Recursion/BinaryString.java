package Recursion;

import java.util.ArrayList;
import java.util.List;

public class BinaryString {
    void genarteBS(StringBuilder str, boolean[] freq, ArrayList<String> list, int n) {
        if (n == str.length()) {
            list.add(str.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!freq[i]) {
                freq[i] = true;
                 str.append('0');
                genarteBS(str , freq, list, n);
                freq[i] = false;
               str.deleteCharAt(str.length()-1);


            }
        }
    }
    void genrateComboBS(int i,String str,ArrayList<String> list,int n){
        if(i==n){
            list.add(str);
            return;
        }
        genrateComboBS(i+1,str+'0',list,n);
        genrateComboBS(i+1,str+'1',list,n);

    }
    void backtrack(int i, int n, List<String> list, StringBuilder sb){
        if(i==n){
            list.add(sb.toString());
            return;
        }
        if(sb.length()==0 || sb.charAt(sb.length()-1)=='1'){
            sb.append('0');
            System.out.println("before appending 0 "+sb);
            backtrack(i+1,n,list,sb);
            sb.deleteCharAt(sb.length()-1);
            sb.append('1');
            backtrack(i+1,n,list,sb);
            sb.deleteCharAt(sb.length()-1);

        }

    }

    public static void main(String[] args) {
        BinaryString bs = new BinaryString();
        int n = 3;
        boolean[] freq = new boolean[n];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        StringBuilder str = new StringBuilder("");
      //  bs.genarteBS(str, freq, list, 3);
      //  bs.genrateComboBS(0,"",list,n);
        bs.backtrack(0,n,list2,str);
     //   System.out.println(list);
        System.out.println("this is second function");
        System.out.println(list2);
    }
}
