package Recursion;

public class Pallidrome {
    boolean checkPallidrome(String str,int s,int e){
        if(s>=e){
            return true;
        }
        if(str.charAt(s)!=str.charAt(e)){
            return false;
        }
        return  checkPallidrome(str, s+1,e-1);
    }
    public static void main(String[] args){
        Pallidrome p=new Pallidrome();
        String str="aakanksha";
        System.out.println( p.checkPallidrome(str,0,str.length()-1));
    }
}
