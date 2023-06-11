package array;

/**
 * @Problem  == You are given an array of prices where prices[i] is the price of a given stock on an ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * @Author saurabh vaish
 * @Date 07-09-2022
 */
public class BuySellStock {

    public static void main(String[] args) {
        int [] ar = {7,1,5,3,6,4};

        System.out.println(maxProfit(ar));

        System.out.println(maxProfitOptimalKadaneAlgo(ar));

    }

    static int maxProfitOptimalKadaneAlgo(int [] ar){
        int sell = 0;
        int buy = ar[0];

        for (int i = 1; i < ar.length; i++) {
            buy = Math.min(buy,ar[i]);  // need to buy min
            sell = Math.max(sell,ar[i]-buy);  // and sell max , so get diff of profit
        }

        return sell;
    }

    // O(N * N )
    // O (1)
    static int maxProfit(int [] ar){
        int max=0;
        for (int i = 0; i < ar.length; i++) {
            int currVal=ar[i];  // current day sum
            for (int j = i; j < ar.length; j++) {
                if(ar[j]>currVal){ // if future value is greater than current val
                    max = Math.max(max,ar[j]-currVal);  // get diff of profit and replace with max
                }
            }
        }

        return max;
    }
}
