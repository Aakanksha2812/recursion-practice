package Greedy;

public class Level1 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if ( n > 0) {
                if (i + 2 < len && flowerbed[i + 2] == 0) {
                    i = i + 2;
                    n--;
                }
            }
        }
        if (n == 0) {
            return true;
        }
        return false;
    }
    public int minTimeToType(String word) {
        int ans = 0;
        int n = word.length();
        int d1 = 0, d2 = 0;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (i == 0) {
                d1 = Math.abs('a' - c);
                d2 =  26-d1;
            } else {
                char c1 = word.charAt(i - 1);
                d1 = Math.abs(c1 - c);
                d2 =  26-d1;
            }
            ans += d1 < d2 ? d1 + 1 : d2 + 1;
        }
        return ans;
    }
    public static void main(String[] args){
        Level1 l=new Level1();
        int[] num={1,0,0,0,0,0,1};
        System.out.println("possible "+l.canPlaceFlowers(num,2));
        System.out.println("minimum oprtions: "+l.minTimeToType("zba"));
    }
}
