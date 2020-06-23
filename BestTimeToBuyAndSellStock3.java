public class BestTimeToBuyAndSellStock3 {

    /**
     * Say you have an array for which the i:th element is the price of a given
     * stock on day i.
     * 
     * Design an algorithm to find the maximum profit. You may complete at most two
     * transactions.
     * 
     * Note: You may not engage in multiple transactions at the same time (i.e., you
     * must sell the stock before you buy again).
     * 
     * Example 1:
     * 
     * Input: [3,3,5,0,0,3,1,4], Output: 6
     * 
     * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit =
     * 3-0 = 3. Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit
     * = 4-1 = 3.
     * 
     * Example 2:
     * 
     * Input: [1,2,3,4,5], Output: 4
     * 
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit =
     * 5-1 = 4. Note that you cannot buy on day 1, buy on day 2 and sell them later,
     * as you are engaging multiple transactions at the same time. You must sell
     * before buying again.
     * 
     * Example 3:
     * 
     * Input: [7,6,4,3,1], Output: 0
     * 
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     */

    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        int maxProfit = 0;
        int nextMaxProfit = 0;
        int currentCheapest = prices[0];

        for (int i = 0; i < prices.length - 1; i++) {
            currentCheapest = Math.min(currentCheapest, prices[i]);
            int currentProfit = Math.max(nextMaxProfit, prices[i + 1] - currentCheapest);

            System.out.println(
                    "day: " + (i + 1) + ", max: " + maxProfit + ", next: " + nextMaxProfit + ", cur: " + currentProfit
                            + ", (" + prices[i + 1] + "-" + currentCheapest + ")" + ", cheapest: " + currentCheapest);

            if (currentProfit > nextMaxProfit) {
                if (currentProfit > maxProfit) {
                    int tmp = maxProfit;
                    maxProfit = currentProfit;
                    nextMaxProfit = tmp;
                    System.out.println("adding max: " + maxProfit + ", max: " + maxProfit + ", next: " + nextMaxProfit
                            + ", cheapest: " + currentCheapest);
                } else {
                    nextMaxProfit = currentProfit;
                    System.out.println("adding nextMax: " + nextMaxProfit + ", max: " + maxProfit + ", next: "
                            + nextMaxProfit + ", cheapest: " + currentCheapest);
                }
                currentCheapest = Integer.MAX_VALUE;
            }
        }

        return maxProfit + nextMaxProfit;
    }

    int[][] mem;

    public int maxProfit1(int[] prices) {
        if (prices.length < 2)
            return 0;

        mem = new int[prices.length][2];
        return Math.max(0, helper(prices, 0, 0, Integer.MAX_VALUE, 0));

    }

    private int helper(int[] prices, int day, int currentProfit, int currentCheapest, int trades) {
        if (day == prices.length - 1) {
            if (trades < 2 && trades >= 0) {
                return Math.max(currentProfit, currentProfit + prices[day] - currentCheapest);
            } else {
                return currentProfit;
            }
        }

        if (trades >= 2) {
            return currentProfit;
        } else {

            if (mem[day][trades] != 0) {
                return mem[day][trades];
            } else {
                currentCheapest = Math.min(currentCheapest, prices[day]);

                int newProfit = Math.max(currentProfit, currentProfit + prices[day] - currentCheapest);

                mem[day][trades] = Math.max(helper(prices, day + 1, newProfit, Integer.MAX_VALUE, trades + 1),
                        helper(prices, day + 1, currentProfit, currentCheapest, trades));

                return mem[day][trades];
            }
        }
    }

    public int maxProfit2(int[] prices) {
        int buyOne = Integer.MAX_VALUE;
        int ProfitOne = 0; // Profit gained after selling 1st share.
        int buyTwo = Integer.MAX_VALUE;
        int ProfitTwo = 0; // Profit gained after selling 2nd share.
        for (int p : prices) {
            buyOne = Math.min(buyOne, p);
            ProfitOne = Math.max(ProfitOne, p - buyOne);

            buyTwo = Math.min(buyTwo, p - ProfitOne); // If I made $100 profit in 1st trans'. Then the 2nd Stock(maybe
                                                      // $300) I buy is actually $300 - $100 = $200 for me.
            ProfitTwo = Math.max(ProfitTwo, p - buyTwo); // And finally The maximum profit I make with the 2nd trans' is
                                                         // my actuall profit with 2 transaction.

            System.out.println("buyOne: " + buyOne + ", buyTwo: " + buyTwo + ", ProfitOne: " + ProfitOne
                    + ", ProfitTwo: " + ProfitTwo);
        }
        return ProfitTwo;
    }

    public int maxProfit3(int[] prices) {
        return 0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock3 b = new BestTimeToBuyAndSellStock3();

        System.out.println(b.maxProfit2(new int[] { 2, 6 })); // 3
        // System.out.println(b.maxProfit2(new int[] { 1, 3, 5, 0, 0, 3, 1, 4 })); // 6
        // System.out.println(b.maxProfit2(new int[] { 1, 2, 3, 4, 5 })); // 4
        // System.out.println(b.maxProfit2(new int[] { 7, 6, 4, 3, 1, 1000, 1, 1, 1, 999
        // })); // 0

        System.out.println(b.maxProfit3(new int[] { 1, 4, 9998, 991497, 9996, 9995, 123, 9993, 9992, 9991, 9990, 9989,
                9988, 9987, 9986, 9985, 9984, 9983, 9982, 9981, 9980, 9979, 9978, 9977, 9976, 9975, 9974, 9973, 9972,
                3245, 9970, 9969, 9968, 9967, 9966, 123, 9964, 9963, 9962, 123, 9960, 9959, 9958, 9957, 9956, 9955,
                9954, 9953, 9952, 123, 9950, 9949, 9948, 9947, 9946, 9945, 9944, 9943, 9942, 9941, 9940, 9939, 9938,
                9937, 9936, 9935, 9934, 9933, 423, 325, 9930, 9929, 9928, 9927, 9926, 9925, 9924, 9923, 9922, 9921,
                9920, 9919, 9918, 9917, 9916, 9915, 9914, 9913, 9912, 9911, 9910, 9909, 9908, 9907, 9906, 9905, 9904,
                9903, 9902, 9901, 9900, 9899, 9898, 9897, 9896, 9895, 9894, 9893, 9892, 9891, 9890, 9889, 9888, 9887,
                9886, 9885, 9884, 9883, 9882, 9881, 9880, 9879, 9878, 9877, 9876, 9875, 9874, 9873, 9872, 9871, 9870,
                9869, 4334, 9867, 9866, 9865, 9864, 9863, 9862, 9861, 9860, 9859, 9858, 9857, 9856, 9855, 9854, 9853,
                9852, 9851, 9850, 9849, 9848, 9847, 9846, 9845, 123, 9843, 9842, 123, 9840, 9839, 9838, 9837, 9836,
                9835, 9834, 9833, 9832, 9831, 9830, 9829, 9828, 9827, 9826, 9825, 9824, 1, 9822, 9821, 9820, 5453, 9818,
                9817, 12341234, 123, 123 }));
    }
}