package String;

public class Solution2 {
    public static String intToString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int c = Character.getNumericValue(s.charAt(i));
            if (c >= 1 && c <= 26) {
                result.append((char) (64 + c));
            }
        }
        return result.toString();
    }

    public String removeTrailingZeros(String num) {
        int len = num.length() - 1;
        System.out.println("before opration " + len);
        int s = len + 1;
        while (len >= 0) {
            if (num.charAt(len) != '0') {
                s = len + 1;
                break;
            }
            len--;
        }
        System.out.println("length " + len + " s " + s);
        String str = new StringBuilder(num).substring(0, s);
        return str;
    }

    public boolean areOccurrencesEqual(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            System.out.println(i);
            count[i]++;
        }
        System.out.println(count);
        for (int i = 0; i < 25; i++) {
            if (count[i] > 0 && count[i + 1] > 0 && count[i] != count[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPresent( String target,String[] arr) {
        if (target == null || arr == null) {
            return false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "51230100";
        Solution2 s = new Solution2();
        //    String ans=s.removeTrailingZeros(str);
        //  System.out.println("ans "+ans);
        String str2 = "aabb";
        System.out.println("same frewun " + s.areOccurrencesEqual(str2));
        System.out.println("Integer String to Letter String: " + s.intToString("12"));
    }
}
