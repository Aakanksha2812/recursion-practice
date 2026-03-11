package Recursion;

import java.util.ArrayList;

public class UniquePartitions {
    void partitions(int i,int n,ArrayList<Integer> list, ArrayList<ArrayList<Integer>> l){
        if(n==0){
            l.add(new ArrayList<>(list));
            return;
        }
        if(i==0){
            return;
        }
        if(i<=n){
            list.add(i);
            partitions(i,n-i,list,l);
            list.remove(list.size()-1);
        }
        partitions(i-1,n,list,l);
    }
    public static void main(String[] args){
        // Code here
        ArrayList<ArrayList<Integer>> l=new ArrayList<>();
        ArrayList<Integer> list=new ArrayList<>();
        int n=2;
        UniquePartitions u=new UniquePartitions();
      //  for(int i=1;i<=n;i++){
            u.partitions(n,n,list,l);
      //  }
        System.out.println(l);
    }
}
