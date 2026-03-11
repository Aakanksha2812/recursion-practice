package Recursion;

import java.util.ArrayList;

public class LastRemain {

        int findLast(ArrayList<Integer> list, int i) {
            if (list.size() == 1) {
                return list.get(0);
            }
            if (i % 2 == 0) {

                for (int j = 0; j < list.size(); j++) {
                    list.remove(j);
                }
            } else {

                for (int j = 1; j < list.size(); j++) {
                    list.remove(j);
                }
            }
            System.out.println(list);
            return findLast(list, i + 1);
        }

       public static void main(String[] args){
            int n=6;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
           System.out.println(list);
            LastRemain l=new LastRemain();
            int ans= l.findLast(list, 0);
        System.out.println(ans);
    }
}
