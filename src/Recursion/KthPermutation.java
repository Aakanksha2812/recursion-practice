package Recursion;

import java.util.ArrayList;

public class KthPermutation {
    static void help( int[] nums, ArrayList<Integer> list, int digit, boolean[] freq, int n, int k) {
        if (String.valueOf(digit).length()==n ) {
            list.add(digit);
            return;
        }
        if (list.size() == k) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                digit = digit * 10 + nums[i];
                help( nums, list, digit, freq, n, k);
                digit = digit / 10;
                freq[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        boolean[] freq = new boolean[4];
        ArrayList<Integer> list = new ArrayList<>();
        int[] nums = new int[4];
        int j = 1;
        for (int i = 0; i < 4; i++) {
            nums[i] = j;
            j++;
        }
        help( nums, list, 0, freq, 4, 3);
        StringBuilder anss = new StringBuilder();
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            anss.append(list.get(i));
        }
        System.out.println(anss.toString());
    }
}
