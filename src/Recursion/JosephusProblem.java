package Recursion;

import java.util.ArrayList;

public class JosephusProblem {
    int func(ArrayList<Integer> list, int i, int k) {
        if (list.size() == 1) {
            return list.get(0);
        }
        int element = (i + k - 1) % list.size();


        list.remove(element);
        return func(list, element, k);

    }

    public int josephus(int n, int k) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        System.out.println(list);
        return func(list, 0, k);
    }

    public static void main(String[] args) {
        JosephusProblem j = new JosephusProblem();
        int ans = j.josephus(5, 2);
        System.out.println(ans);

    }
}
