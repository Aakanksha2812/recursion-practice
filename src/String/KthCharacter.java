package String;

public class KthCharacter
{
    char help(String s,int k){
        if(s.length()>=k){
            s.charAt(k-1);
        }

     //   String gS=s+s.charAt(s.length()-1)+(s.charAt(s.length()-1)+1);
        String gS=s+(s.charAt(s.length()-1)+1);
        System.out.println(gS);
        char a=help(gS,k);
        System.out.println("this is a "+a);
        return a;
    }
    public char kthCharacter1(int k) {
        String s="a";
        return help(s,k);
    }
    public static void main(String[] args){
        KthCharacter k=new KthCharacter();
        System.out.println(k.kthCharacter1(5));
    }
}
