package Recursion;

import java.sql.Array;
import java.util.ArrayList;

public class FibonnacciSeries {
    int series(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }


        return series(n - 1) + series(n - 2);

    }

    ArrayList<Integer> seriesFibbo(ArrayList<Integer> list, int n) {

        for (int i = 0; i <= n; i++) {
            list.add(series(i));
        }
        return list;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        FibonnacciSeries f = new FibonnacciSeries();
        System.out.println(f.seriesFibbo(list, 5));
        System.out.println(list);
    }
}
