package Mock;

public class Second {
    public int maxProfit(int[] prices){
        int n=prices.length;
        int buy=Integer.MAX_VALUE,profit=0;
        for (int i = 0; i < n; i++) {
           if (buy>prices[i]){
               buy=prices[i];
           }
          else{
               profit = Math.max(profit, prices[i] - buy);
           }
        }
        return profit;
    }
    public static void main(String[] args){
        Second s=new Second();
        int[] prices={7,1,5,3,6,4};
        System.out.println("maximum profit is: "+s.maxProfit(prices));
    }
}
