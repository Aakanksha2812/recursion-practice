package Recursion;

import java.util.ArrayList;

public class EvenNumber {

    void collectNumber(int[] digits, int i, int num, ArrayList<Integer> list) {
        if (num > 99 && num < 1000) {
            if (num % 2 == 0) {
                list.add(num);
            }
            return;
        }
        for (int j = i; j < digits.length; j++) {
            num = num * 10 + digits[j];
            collectNumber(digits, j + 1, num, list);
            num = num / 10;
        }

    }

    public static void main(String[] args) {
        EvenNumber e = new EvenNumber();
        int[] digits = new int[]{2, 1, 3, 0};
        ArrayList<Integer> list = new ArrayList<>();
        e.collectNumber(digits, 0, 0, list);
        System.out.println(list);


    }

}
