package Recursion.chatGptQuestionPractice;

import java.util.ArrayList;
import java.util.HashSet;

import static Recursion.chatGptQuestionPractice.Level2Questions.pallidrome;

public class Level3Question {
    String vowel = "AEIOU";

    void binaryString(int i, StringBuilder sb, ArrayList<String> list, int n) {
        if (i == n) {
            list.add(sb.toString());
            return;
        }
        sb.append('0');
        binaryString(i + 1, sb, list, n);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('1');
        binaryString(i + 1, sb, list, n);
        sb.deleteCharAt(sb.length() - 1);
    }

    void binaryString2(int i, StringBuilder sb, ArrayList<String> list, int n) {
        if (i == n) {

            list.add(sb.toString());

            return;
        }
        if (i == 0 || (i > 0 && sb.charAt(sb.length() - 1) != '1')) {
            sb.append('1');
            binaryString2(i + 1, sb, list, n);
            sb.deleteCharAt(sb.length() - 1);
        }


        sb.append('0');
        binaryString2(i + 1, sb, list, n);
        sb.deleteCharAt(sb.length() - 1);
    }

    void increasingDigits(int digit, int n, ArrayList<Integer> list) {
        if (digit > 99 && digit < 1000) {
            list.add(digit);
            return;
        }
        if (n > 9) {
            return;
        }
        digit = digit * 10 + n;
        increasingDigits(digit, n + 1, list);
        digit = digit / 10;
        increasingDigits(digit, n + 1, list);
    }

    void stairCaseJumpCombo(int i, int n, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (i == n) {
            store.add(new ArrayList<>(list));
            return;
        }
        if (i > n) {
            return;
        }
        for (int j = 1; j <= 3; j++) {
            list.add(j);
            stairCaseJumpCombo(i + j, n, list, store);
            list.remove(list.size() - 1);
        }
    }

    void KLengthString(String s, StringBuilder sb, ArrayList<String> list, int k) {
        if (sb.length() == k) {
            list.add(sb.toString());
            return;
        }
        for (int j = 0; j < s.length(); j++) {
            if (!sb.isEmpty() && sb.charAt(sb.length() - 1) == s.charAt(j)) {
                continue;
            }

            sb.append(s.charAt(j));
            KLengthString(s, sb, list, k);
            sb.deleteCharAt(sb.length() - 1);

        }
    }

    void expressionCombo(int i, int[] num, ArrayList<Integer> list, int ans) {
        if (i == num.length) {
            list.add(ans);
            return;
        }
        ans = ans + num[i];
        expressionCombo(i + 1, num, list, ans);
        ans = ans - num[i];
        ans = ans - num[i];
        expressionCombo(i + 1, num, list, ans);
    }

    void validSegmenet(int i, String s, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (i == s.length()) {
            store.add(new ArrayList<>(list));
            return;
        }
        if (s.charAt(i) == '0') {
            return;
        }
        list.add(s.charAt(i) - '0');
        validSegmenet(i + 1, s, list, store);
        list.remove(list.size() - 1);
        if (i + 1 < s.length()) {
            int first = s.charAt(i) - '0';
            int second = s.charAt(i + 1) - '0';
            int digit = first * 10 + second;
            if (digit > 9 && digit < 27) {
                list.add(digit);
                validSegmenet(i + 2, s, list, store);
                list.remove(list.size() - 1);
            }
        }
    }

    void balncedBites(int i, int n, int zeroCount, int oneCount, StringBuilder sb, ArrayList<String> list) {
        if (i == n) {
            list.add(sb.toString());
            return;
        }

        if (zeroCount < n / 2) {
            sb.append('0');
            balncedBites(i + 1, n, zeroCount + 1, oneCount, sb, list);
            sb.deleteCharAt(sb.length() - 1);

        }
        if (oneCount < n / 2) {
            sb.append('1');
            balncedBites(i + 1, n, zeroCount, oneCount + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    void expressionBuilder(int i, String s, StringBuilder sb, ArrayList<String> list) {
        if (i == s.length()) {
            list.add(sb.toString());
            return;
        }
        int len = sb.length();
        sb.append(s.charAt(i));
        if (i == s.length() - 1) {
            list.add(sb.toString());
        } else {
            sb.append('+');
            expressionBuilder(i + 1, s, sb, list);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('*');
            expressionBuilder(i + 1, s, sb, list);
            sb.deleteCharAt(sb.length() - 1);

            expressionBuilder(i + 1, s, sb, list);

        }
        sb.setLength(len);


    }

    boolean equalPartitions(int i, int[] nums, int sum) {

        if (sum == 0) {
            return true;
        }
        if (i == nums.length || sum < 0) {
            return false;
        }
        boolean in = equalPartitions(i + 1, nums, sum - nums[i]);
        boolean ex = equalPartitions(i + 1, nums, sum);
        return in || ex;
    }

    /* void permutationString(String s, StringBuilder sb, boolean[] freq, ArrayList<String> list) {
         if (s.length() == sb.length()) {
             list.add(sb.toString());
             return;
         }
         for (int i = 0; i < s.length(); i++) {
             if (freq[i]) {
                 continue;
             }
             if (i > 0 && vowel.contains(String.valueOf(s.charAt(i))) &&
                     vowel.contains(String.valueOf(s.charAt(i-1)) )) {

                 continue;
             }

             freq[i] = true;
             sb.append(s.charAt(i));
             permutationString(s, sb, freq, list);
             sb.deleteCharAt(sb.length() - 1);
             freq[i] = false;

         }
     }*/
    void alphNumeric(StringBuilder sb, int n, ArrayList<String> list, boolean isLetter, char[] letters, char[] digits, boolean[] usedL, boolean[] usedD) {
        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        if (isLetter) {
            for (int i = 0; i < digits.length; i++) {
                if (!usedD[i]) {
                    usedD[i] = true;
                    sb.append(digits[i]);
                    alphNumeric(sb, n, list, false, letters, digits, usedL, usedD);
                    sb.deleteCharAt(sb.length() - 1);
                    usedD[i] = false;
                }
            }
        } else {
            for (int i = 0; i < letters.length; i++) {
                if (!usedL[i]) {
                    usedL[i] = true;
                    sb.append(letters[i]);
                    alphNumeric(sb, n, list, true, letters, digits, usedL, usedD);
                    sb.deleteCharAt(sb.length() - 1);
                    usedL[i] = false;
                }
            }
        }
    }

    void letterCase(int i, String s, StringBuilder sb, ArrayList<String> list) {

        if (i == s.length()) {
            list.add(sb.toString());
            return;
        }

        char ch = s.charAt(i);

        if (Character.isDigit(ch)) {
            sb.append(ch);
            letterCase(i + 1, s, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        } else {

            sb.append(Character.toLowerCase(ch));
            letterCase(i + 1, s, sb, list);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(Character.toUpperCase(ch));
            letterCase(i + 1, s, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    void palindromePartition(int i, String s,
                             ArrayList<String> list,
                             ArrayList<ArrayList<String>> store) {

        if (i == s.length()) {
            store.add(new ArrayList<>(list));
            return;
        }

        for (int j = i; j < s.length(); j++) {

            if (pallidrome(s, i, j)) {

                String part = s.substring(i, j + 1);
                list.add(part);

                palindromePartition(j + 1, s, list, store);

                list.remove(list.size() - 1);
            }
        }
    }

    void diceRollCombo(int i, int sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (i == sum) {
            store.add(new ArrayList<>(list));
            return;
        }
        if (i > sum) {
            return;
        }
        for (int j = 1; j <= 6; j++) {
            if (i + j > sum) {
                break;
            }
            list.add(j);
            diceRollCombo(i + j, sum, list, store);
            list.remove(list.size() - 1);
        }
    }

    void diceRollWithFreq(int sum, int count, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> store) {
        if (list.size() == count) {
            if (sum == 0) {
                store.add(new ArrayList<>(list));
            }
            return;
        }
        if (sum < 0) {
            return;
        }
        for (int i = 1; i <= 6; i++) {

            list.add(i);
            diceRollWithFreq(sum - i, count, list, store);
            list.remove(list.size() - 1);

        }
    }
    void generateStrFromChar(char[] chars,StringBuilder sb,ArrayList<String> list,int len){
        if(len==sb.length()){
            list.add(sb.toString());
            return;
        }
       for (char c:chars){
           sb.append(c);
           generateStrFromChar(chars,sb,list,len);
           sb.deleteCharAt(sb.length()-1);
       }
    }
    void binaryStringFromab(int len,StringBuilder sb,ArrayList<String> list){
        if(sb.length()==len){
            list.add(sb.toString());
            return;
        }
        if(sb.length()==0 || sb.charAt(sb.length()-1)!='b'){
            sb.append('b');
            binaryStringFromab(len,sb,list);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append('a');
        binaryStringFromab(len,sb,list);
        sb.deleteCharAt(sb.length()-1);

    }

    public static void main(String[] arg) {
        Level3Question l = new Level3Question();
        ArrayList<String> list = new ArrayList<>();
        int n = 3;
        l.binaryString2(0, new StringBuilder(""), list, n);
        System.out.println(list);
        ArrayList<Integer> list1 = new ArrayList<>();
        l.increasingDigits(0, 1, list1);
        System.out.println(list1);
        ArrayList<ArrayList<Integer>> store = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        System.out.println("staircase problem");
        l.stairCaseJumpCombo(0, n, list2, store);
        System.out.println(store);
        ArrayList<String> list3 = new ArrayList<>();
        l.KLengthString("abc", new StringBuilder(""), list3, 3);
        System.out.println(list3);
        ArrayList<Integer> list4 = new ArrayList<>();
        int[] num = new int[]{1, 2, 3};
        l.expressionCombo(0, num, list4, 0);
        System.out.println(list4);
        ArrayList<ArrayList<Integer>> store1 = new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();
        l.validSegmenet(0, "101", list5, store1);
        System.out.println(store1);
        System.out.println((char) (5 + '0'));
        ArrayList<String> list6 = new ArrayList<>();
        l.balncedBites(0, 4, 0, 0, new StringBuilder(""), list6);
        System.out.println(list6);
        ArrayList<String> list7 = new ArrayList<>();
        l.expressionBuilder(0, "123", new StringBuilder(""), list7);
        System.out.println(list7);
        System.out.println(list7.size());
        int[] nums = new int[]{2, 1, 4, 5, 6};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        ArrayList<String> list8 = new ArrayList<>();
        ArrayList<ArrayList<String>> store2 = new ArrayList<>();
        System.out.println(l.equalPartitions(0, nums, sum / 2));
        boolean[] freq = new boolean[3];
        //      l.permutationString("AEC", new StringBuilder(), freq, list8);
        char[] letters = {'A', 'B'};
        char[] digits = {'1', '2'};
        boolean[] usedL = new boolean[letters.length];
        boolean[] usedD = new boolean[digits.length];
        l.alphNumeric(new StringBuilder(""), 4, list8, false, letters, digits, usedL, usedD);
        l.alphNumeric(new StringBuilder(""), 4
                , list8, true, letters, digits, usedL, usedD);
        System.out.println(list8);
        ArrayList<String> list9 = new ArrayList<>();
        l.letterCase(0, "a1b", new StringBuilder(""), list9);
        System.out.println(list9);
        ArrayList<String> list10 = new ArrayList<>();
        l.palindromePartition(0, "aab", list10, store2);
        System.out.println(store2);
        ArrayList<Integer> list11 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> store3 = new ArrayList<>();
        l.diceRollCombo(0, 6, list11, store3);
        System.out.println(store3);
        ArrayList<Integer> list12 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> store4 = new ArrayList<>();

        l.diceRollWithFreq(7, 2, list12, store4);
        System.out.println(store4);
        char[] chars=new char[]{'a','b','c'};
        ArrayList<String> list13 = new ArrayList<>();
        l.generateStrFromChar(chars,new StringBuilder(""),list13,2);
        System.out.println(list13);
        ArrayList<String> list14 = new ArrayList<>();
        l.binaryStringFromab(3,new StringBuilder(""),list14);
        System.out.println(list14);
    }
}
