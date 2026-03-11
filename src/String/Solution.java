package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        HashSet<String> set = new HashSet<>();
        int count=0;
        for (String s : words) {
            set.add(s);
        }
        System.out.println(set);
        for(String s:words){
            StringBuilder str=new StringBuilder(s);
            System.out.println("strrrr  "+str);
            if(set.contains(str.reverse())){
                System.out.println("inside if"+str.reverse());
                count++;
            }
        }
        return count/2;
    }
    public int finalPositionOfSnake(int n, List<String> commands) {
        int count = 0;
        int i = 0, j = 0;
        int val = (i * n) + j;
        while (count < commands.size() && i < n && j < n) {
            System.out.println("command is "+commands.get(count));
            if (commands.get(count).equals("UP")) {
                val = ((i - 1) * n) + j;
                i = i - 1;
                System.out.println("i am here " + val + " i " + i + " j " + j);
            } else if (commands.get(count).equals("RIGHT")) {
                val = (i * n) + (j + 1);
                j = j + 1;
                System.out.println("i am here " + val + " i " + i + " j " + j);
            } else if (commands.get(count).equals("DOWN")) {
                val = ((i + 1) * n) + j;
                i = i + 1;
                System.out.println("i am here " + val + " i " + i + " j " + j);
            } else if (commands.get(count).equals("LEFT")) {
                val = (i * n) + (j - 1);
                j = j - 1;
                System.out.println("i am here " + val + " i " + i + " j " + j);
            }
            count++;

        }
        return val;
    }

    public String replaceDigits(String s) {
        StringBuilder result = new StringBuilder();
        char[] c = s.toCharArray();
        int i = 0;
        while (i < c.length) {
            int n = c[i + 1] - '0';
            char ch = (char) (c[i] + n);
            c[i + 1] = ch;
            i = i + 2;
        }
        return String.valueOf(c);

    }

    public int countAsterisks(String s) {
        boolean flag = true;
        int ans = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '|') {
                flag = !flag;
            }
            if (flag) {
                ans++;
            }

        }
        return ans;
    }

    public String sortSentence(String s) {


        String[] sArray = s.split(" ");
        String[] ans = new String[sArray.length];
        for (String str : sArray) {
            System.out.println("String " + str + " length" + str.length());
            int len = str.length() - 1;
            int idx = str.charAt(len) - '0';
            ans[idx - 1] = str.substring(0, len);
        }
        String a = String.join(" ", ans);
        return a;
    }

    public int prefixCount(String[] words, String pref) {
        //  int len = pref.length();
        char[] p = pref.toCharArray();
        int ans = 0;
        for (String s : words) {
            char[] c = s.toCharArray();
            int flag = 0;
            for (int i = 0; i < p.length; i++) {

                if (c[i] != p[i]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                ans++;
            }

        }
        return ans;

    }

    public static void main(String[] args) {

        Solution s = new Solution();
       /*String ans = s.sortSentence(str);
        String str = "is2 sentence4 This1 a3";
      / System.out.println("after sorting " + ans);
        String str1="a1c1e1";
        String ans=s.replaceDigits(str1);
        System.out.println(ans);*/
        List<String> l = Arrays.asList("RIGHT", "DOWN");
        int ans2 = s.finalPositionOfSnake(2, l);
        System.out.println(ans2);
        String[] words =new String[] {"cd","ac","dc","ca","zz"};
        int ans3=s.maximumNumberOfStringPairs(words);
        System.out.println(ans3);


    }
}