package String;

import java.util.HashMap;

public class StringPractice {
   /* public int maxFreqSum(String s) {
        int vMax = 0;
        int cMax = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i) - 'a', map.getOrDefault(s.charAt(i), 0) + 1);
        }
//int i=0;
        // System.out.println("i "+i+" vmax  "+vMax+" cmax "+cMax);
        for (Integer key : map.keySet()) {
            //  int i=s.charAt(key)-'a';
            if (map.containsKey(key) && (key == 0 || key == 4 || s.charAt(key) == 8
                    || s.charAt(key) == 14 || s.charAt(key) == 20)) {
                if (vMax < map.get(key)) {
                    vMax = map.get(key);
                }
            }
            if (map.containsKey(key) && (key != 0 || key != 4 || s.charAt(key) != 8
                    || s.charAt(key) != 14 || s.charAt(key) != 20)) {
                if (cMax < map.get(key)) {
                    cMax = map.get(key);
                }
            }
        }


        System.out.println(map);
        System.out.println("vmax  " + vMax + " cmax " + cMax);
        return vMax + cMax;
    }
*/
    String charToDigit(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) ;
            ans.append(c);

        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "aeiaeiass";
        StringPractice object = new StringPractice();
        /*int ans = object.maxFreqSum(s);
        System.out.println(ans);*/
        System.out.println("Digit for that string "+object.charToDigit("BBF"));
    }

}
