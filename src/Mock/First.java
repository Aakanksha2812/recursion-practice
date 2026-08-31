package Mock;

public class First {
    public int minTransactions(int[] balance) {
        int negative=0;
        for(int num:balance){
            if (num<0){
                negative++;
            }
        }
        return negative;
    }

}
