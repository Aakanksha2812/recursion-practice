package Recursion.chatGptQuestionPractice;

import java.util.ArrayList;

public class Level2Questions {
    void reverseString(String s, int i, ArrayList<Character> list) {
        if (i == s.length()) {
            return;
        }
        reverseString(s, i + 1, list);
        list.add(s.charAt(i));
    }

 public static     boolean pallidrome(String str, int s, int e) {
        if (s >= e) {
            return true;
        }
        if (str.charAt(s) != str.charAt(e)) {
            return false;
        }
        return pallidrome(str, s + 1, e - 1);
    }

    int maximum(int[] arr, int max, int i) {
        if (arr.length == i) {
            return max;
        }
        if (max < arr[i]) {
            max = arr[i];
        }
        return maximum(arr, max, i + 1);
    }

    int frequencyOfArray(int[] arr, int i, int x, int count) {
        if (arr.length == i) {
            return count;
        }
        if (arr[i] == x) {
            return frequencyOfArray(arr, i + 1, x, count + 1);

        } else {
            return frequencyOfArray(arr, i + 1, x, count);
        }
    }
    boolean isArraySorted(int[] arr,int i){
        if(i==arr.length){
            return true;
        }
        if(arr[i-1]>arr[i]){
            return false;
        }
        return isArraySorted(arr,i+1);
    }
  String removeOccurancesOfChar(String s,StringBuilder sb,int i,char c){
        if(i==s.length()){
            return  sb.toString();
        }
        if(s.charAt(i)!=c){
            sb.append(s.charAt(i));
        }
        return removeOccurancesOfChar(s,sb,i+1,c);
  }
  void subsequnceofString(int i,String s,ArrayList<String> list,StringBuilder sb){
        if(i==s.length()){
            list.add(sb.toString());
            return;
        }
        sb.append(s.charAt(i));
        subsequnceofString(i+1,s,list,sb);
        sb.deleteCharAt(sb.length()-1);
        subsequnceofString(i+1,s,list,sb);
  }
  int sumOfDigits(int num,int sum){
        if(num==0){
            return  sum;
        }
        int l=num%10;
        return sumOfDigits(num/10,sum+l);
  }
  void subSetOfArray(int i, int[] num,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> store){
        if(i==num.length){
            store.add(new ArrayList<>(list));
            return;
        }
        list.add(num[i]);
        subSetOfArray(i+1,num,list,store);
        list.remove(list.size()-1);
        subSetOfArray(i+1,num,list,store);
  }
    public static void main(String[] args) {
        Level2Questions l = new Level2Questions();
        ArrayList<Character> list = new ArrayList<>();
        l.reverseString("AAKANKSHA", 0, list);
        System.out.println(list);
        System.out.println("String is pallidrom " + l.pallidrome("MADAM", 0, 4));
        System.out.println("String is pallidrom " + l.pallidrome("AAKANKSHA", 0, 8));
        int[] arr = new int[]{22, 77, 0, 19, 56, 3, 22};
        int[] arr2 = new int[]{1,2,3,4,5};
        System.out.println(l.maximum(arr, 0, 0));
        int count = 0;
        System.out.println(l.frequencyOfArray(arr, 0, 22, count));
        System.out.println(l.isArraySorted(arr2,1));

        System.out.println(l.removeOccurancesOfChar("aakanksha",new StringBuilder(""),0,'a'));
        String s="ABC";
        ArrayList<String> list2=new ArrayList<>();
        l.subsequnceofString(0,s,list2,new StringBuilder(""));
        System.out.println(list2);
        System.out.println(list2.size());
        System.out.println(l.sumOfDigits(4444,0));
        int[] num=new int[]{1,2,3,4};
        ArrayList<ArrayList<Integer>> store=new ArrayList<>();
        ArrayList<Integer> list3=new ArrayList<>();
        l.subSetOfArray(0,num,list3,store);
        System.out.println(store);

    }
}
