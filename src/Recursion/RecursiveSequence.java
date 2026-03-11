package Recursion;

public class RecursiveSequence {
    static int mod = 1000000007;

    static long help(int count, int i) {
        if (i == 0) {
            return 1;
        }
        System.out.println(count + " count " + i);
        return count * help(count + 1, i - 1);

    }

    static long sequence(int n) {
        // code here
        long sum = 0;
        int count = 1;
        for (int i = 0; i < n; i++) {
            count = i + count;
            sum = sum + help(count, i+1);
            System.out.println(count + " sum " + sum);
        }
        return sum % mod;
    }

    public static void main(String[] args) {
        RecursiveSequence r = new RecursiveSequence();
        System.out.println(r.sequence(5));
    }
}