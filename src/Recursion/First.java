package Recursion;

public class First {
    String name(String s, int n) {
        if (n == 0) {
            return "";
        }

        System.out.println(s);
        return name(s, n - 1);

    }
    String reverseString(String s,int i){
        if(i==s.length()){
            return "";
        }
     /*  String str=reverseString(s,i+1);
        System.out.print(s.charAt(i));*/
        return reverseString(s,i+1)+s.charAt(i);
    }
    boolean isStringPallimdrome(String str,int s,int e){
        if(s>=e){
            return true;
        }
        char start=str.charAt(s);
        char end=str.charAt(e);
        boolean flag=isStringPallimdrome(str,s+1,e-1);
        if(start!=end){
            System.out.println("failed on call no "+s);
            return false;
        }
        return flag;
    }
    boolean isStringPallimdromeTail(String str,int s,int e){
        if(s>=e){
            return true;
        }
        char start=str.charAt(s);
        char end=str.charAt(e);
        if(start!=end){
            System.out.println("failed on call no "+s);
            return false;
        }
        boolean flag=isStringPallimdromeTail(str,s+1,e-1);

        return flag;
    }
    boolean check(String str,int s,int e){
        if(s>=e){
            return true;
        }
        if(str.charAt(s)!=str.charAt(e)){
            return false;
        }
        return check(str,s+1,e-1);
    }
    public boolean isPalindrome(String s) {
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isLetter(c))
            {

                str.append(c);
            }
        }
        System.out.println(str);
        return check(str.toString().toLowerCase(),0,str.length()-1);
    }


    public static void main(String[] args) {
        String s = "SHREE SWAMI SAMARTH";
        First f = new First();

      /*  String ans = f.name(s, 5);
        System.out.println(ans);*
       */
        String s1="hello";
        String ans2=f.reverseString(s1,0);
        System.out.println(ans2);
        String s2="MADAM";
        String s3="AAKANKSHA";
        String s4="0P";
        String s5="A man, a plan, a canal: Panama";
        System.out.println("ans is "+f.isStringPallimdromeTail(s4,0,s4.length()-1));
        System.out.println("leetcode problem "+f.isPalindrome(s5));

    }
}
