package Recursion.chatGptQuestionPractice;

import java.util.ArrayList;

public class BasicQuestion {
    void  print1ton(int n, ArrayList<Integer> list){
        if(n==0){
            return ;
        }
        list.add(n);
        print1ton(n-1,list);


    }
    int sum(int n){
        if(n==0){
            return 0;
        }
        return n+sum(n-1);
    }
    int factorial(int n){
        if(n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
    int countDigits(int n,int count){
        if(n==0){
            return count;
        }
        return countDigits(n/10, count+1);

    }
    public static void main(String[] args){
        BasicQuestion b=new BasicQuestion();
        ArrayList<Integer> list=new ArrayList<>();
      //  b.print1ton(5);
       b.print1ton(5,list);
        System.out.println(list);
        System.out.println(b.sum(5));
        System.out.println(b.factorial(5));
        System.out.println(b.countDigits(15,0));
    }
}
