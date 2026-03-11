package String;
import java.util.HashMap;
public class ArrayStringEqual {

        public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            for (String s : word1) {
                for (int i = 0; i < s.length(); i++) {
                    s1.append(s.charAt(i));
                }
            }
            for (String s:word2) {
                for (int i = 0; i < s.length(); i++) {
                    s2.append(s.charAt(i));
                }
            }
            System.out.println("first String "+s1+" second String "+s2);
            if (s1.toString().equals(s2.toString())) {
                return true;
            }
            return false;


    }
    public String decodeMessage(String key, String message) {
        HashMap<Character, Character> map = new HashMap<>();
        StringBuilder s = new StringBuilder();
        char[] c = key.toCharArray();
        int alphbet = 97;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != ' ') {
                map.put(c[i], (char) alphbet);
                alphbet++;
            }
        }
        System.out.println(map);
        char[] m = message.toCharArray();
        for (int i = 0; i < m.length; i++) {
            if (m[i] == ' ') {
                s.append(' ');
            } else {
                s.append(map.get(m[i]));
            }
        }
        return s.toString();

    }

    public static void main(String[] args){
            String[] word1=new String[]{"ab", "c"};
            String[] word2=new String[]{"a", "bc"};
            String s="the quick brown fox jumps over the lazy dog";
            char[] c=s.toCharArray();
            System.out.println(c);
            String m="vkbs bs t suepuv";
            ArrayStringEqual a=new ArrayStringEqual();
           // boolean ans=a.arrayStringsAreEqual(word1,word2);
       //     System.out.println("ans   "+ans);
            String ans2=a.decodeMessage(s,m);
        System.out.println("ans   "+ans2);

    }
}
