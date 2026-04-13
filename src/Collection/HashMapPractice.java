package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    int frequencyOfElement(ArrayList<Integer> list) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int e : list) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) == 1) {
                return list.get(i);
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        HashMapPractice hm = new HashMapPractice();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 7, 11, 15));
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(2, 3, 4, 3, 2));
        int[] ans = hm.twoSum(list, 9);
        printArrayMethod(ans);
        System.out.println();
        System.out.println("first non repeating elemnet " + hm.frequencyOfElement(list1));
    }


}
