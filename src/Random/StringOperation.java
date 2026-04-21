package Random;

public class StringOperation {
    String trimIt(String s){
      return  s.strip();
    }
    public int lengthOfLastWord(String s) {
        s.trim();
        System.out.println(s);
        int count=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                break;
            }
            count++;
        }
        return count;
    }
    public static void main(String args[]){
        StringOperation s=new StringOperation();
      String str="  SHREE   SWAMI SAMARTH ";
String str2="   fly me   to   the moon  ";
        System.out.println(s.trimIt(str));
        System.out.println(s.lengthOfLastWord(str2));
    }
}
