package Recursion.chatGptQuestionPractice;

import java.util.ArrayList;

public class Level4Question {
    void permutationOfString(String s, StringBuilder sb, boolean[] freq, ArrayList<String> list){
        if(s.length()==sb.length()){
            list.add(sb.toString());
            return;
        }
        for (int i=0;i<s.length();i++){
            if(!freq[i]){
                freq[i]=true;
                sb.append(s.charAt(i));
                permutationOfString(s,sb,freq,list);
                sb.deleteCharAt(sb.length()-1);
                freq[i]=false;
            }
        }
    }
    void subSetSum(int i,int[] num,int target,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> store){
        if(i==num.length){
            if(target==0){
                store.add(new ArrayList<>(list));
            }
            return;
        }
        if(num[i]<=target){
            list.add(num[i]);
            subSetSum(i+1,num,target-num[i],list,store);
            list.remove(list.size()-1);
        }
       // list.add()
        subSetSum(i+1,num,target,list,store);
    }
    public static void main(String[] args){
        System.out.println("SHREE SWAMI SAMARTH");
        Level4Question l=new Level4Question();
        ArrayList<String> list=new ArrayList<>();
        ArrayList<ArrayList<Integer>> store=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        int[] num=new int[]{1,3,4,2,1,5};
        String s="ABC";
        boolean[] freq=new boolean[s.length()];
        l.permutationOfString(s,new StringBuilder(""),freq,list);
        System.out.println(list);
        l.subSetSum(0,num,7,list1,store);
        System.out.println(store);
    }
}
