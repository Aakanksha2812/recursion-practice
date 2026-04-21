package Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {

    public boolean checkAnagram(String s1, String s2) {
        char[] char1 = s1.toCharArray();
        char[] char2 = s2.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        if (Arrays.equals(char1, char2)) {
            return true;
        }
        return false;
    }

    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        //  int i = 0;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                String s1 = words[i];
                String s2 = words[j];
                if (i != j && checkAnagram(s1, s2)) {
                    if (!ans.contains(s2)) {
                        ans.add(s2);
                    }


                }


            }
        }
        return ans;

    }

    public int getLeastFrequentDigit(int n) {
        int min = Integer.MAX_VALUE;
        int d = n;
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (n != 0) {
            int m = n % 10;
            n = n / 10;
            map.put(m, map.getOrDefault(m, 0) + 1);

            if (map.containsKey(m)) {
                if (min > map.get(m)) {
                    min = map.get(m);
                }
            }

        }
        System.out.println(map);
        System.out.println("minimum frequncy is " + min);
        while (d != 0) {
            int m = d % 10;

            if (min == map.get(m)) {

                if (ans > m) {
                    ans = m;
                }
            }
            d /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("SHREE SWAMI SAMARTH");
        String[] words = new String[]{"abba", "baba", "bbaa", "cd", "cd"};
        List<String> ans = new ArrayList<>();
        int n = 11;
        Anagram a = new Anagram();
        // ans = a.removeAnagrams(words);
        int ans2 = a.getLeastFrequentDigit(n);
        System.out.println(ans2);
    }
}
