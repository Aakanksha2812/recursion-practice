package Recursion;

import java.util.ArrayList;

public class LetterCombination {
    void letterCombo(int i, int j, ArrayList<String> list, StringBuilder sb,String s1,String s2) {

        if (sb.length() >= s1.length()) {
            list.add(sb.toString());
            return;
        }
        if (j >=s2.length()) {
            return;
        }
       // sb.append(s1.charAt(i));
      //  System.out.println("looking for j chacter "+s2.charAt(j));
        sb.append(s2.charAt(j));
        letterCombo(i,j+1,list,sb,s1,s2);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb+" j "+j );
        letterCombo(i,j+1,list,sb,s1,s2);
    }

    public static void main(String[] args) {
        String s1 = "pqrs";
        String s2 = "";
        ArrayList<String> list = new ArrayList<>();

        LetterCombination l = new LetterCombination();
        for (int i = 0; i < s1.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(s1.charAt(i));
            l.letterCombo(i, 0, list, sb,s1,s2);
        }
        System.out.println(list);
    }
}
