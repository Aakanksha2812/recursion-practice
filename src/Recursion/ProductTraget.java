package Recursion;

import java.util.ArrayList;

public class ProductTraget {
    void product(int i, int[] nums, long target, long prod, ArrayList<Long> list) {
        if (i == nums.length) {

            if (target == 1) {
                list.add(prod);
            }
            return;
        }
        prod = prod * nums[i];

        product(i + 1, nums, target / nums[i], prod, list);

        prod = prod / nums[i];
        product(i + 1, nums, target, prod, list);
    }

    public static void main(String[] args) {
        ArrayList<Long> list = new ArrayList<>();
        int[] nums = new int[]{3, 1, 6, 8, 4};
        long target = 24;
        ProductTraget p = new ProductTraget();
        p.product(0, nums, target, 1, list);
        System.out.println(list);
        if (list.size() > 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
