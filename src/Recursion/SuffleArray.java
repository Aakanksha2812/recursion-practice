package Recursion;

public class SuffleArray {

    void shuffleArr(int i,int a,int b,long arr[],long aitem,long bitem,boolean flag){
        if(i==arr.length){
            return;
        }
        System.out.println(aitem +" "+bitem);
        if(flag){
            arr[i]=aitem;
            ++a;
            aitem=arr[a];
            flag=false;
            shuffleArr(i+1,a+1,b,arr,aitem,bitem,flag);
        }
        else{
            arr[i]=bitem;
            if(++b<arr.length){
                bitem=arr[b];}
            flag=true;
            shuffleArr(i+1,a,b,arr,aitem,bitem,flag);
        }
    }
    public static void main(String[] args){
        long[] arr=new long[]{1,2,3,4,5,6,7,8,9,10};
        SuffleArray s=new SuffleArray();
        int n=arr.length;
        long aitem=arr[0];
        long bitem=arr[n/2];

        s.shuffleArr(0,0,n/2,arr,aitem,bitem,true);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

}}
