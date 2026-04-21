package Random;

import java.util.HashMap;

public class First {

    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        int ans = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num)) {
                if (max < map.get(num)) {
                    max = map.get(num);
                }

            }
        }
        System.out.println("max " + max);
        map.forEach((key, value) -> {
            System.out.println("key " + key + " " + "value " + value);
        });

        return ans;


    }

    public static void main(String[] args) {
        System.out.println("GANPATI BAPPA MORYA");
        First f = new First();
        int[] nums = new int[]{1, 2, 3, 1, 4};
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int ans = f.maxFrequencyElements(nums);
        System.out.println(ans);
    }
}
