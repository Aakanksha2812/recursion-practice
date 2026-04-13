package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static Print.PrintFunction.printArrayMethod;

public class HashMapPractice {
    int[] twoSum(ArrayList<Integer> list, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int sum = target - list.get(i);
            if (map.containsKey(sum)) {
                return new int[]{map.get(sum), i};
            }
            map.put(list.get(i), i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        HashMapPractice hm = new HashMapPractice();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 7, 11, 15));

        int[] ans = hm.twoSum(list, 9);
        printArrayMethod(ans);
    }


}
