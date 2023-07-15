package array_examples;

public class BestTimetoBuy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) return 0;

        int[] minSoFar = new int[]{0,prices[0]};
        int[] maxSoFarAfterRecentMin = new int[]{0,prices[0]};
        int profit = 0;

        for(int i=1;i<prices.length;i++){
            if (prices[i] < minSoFar[1]){
                minSoFar[0] = i;
                minSoFar[1] = prices[i];

                maxSoFarAfterRecentMin[0] = -1;     // encountered min - no point to remember last max before this.
                maxSoFarAfterRecentMin[1] = -1;     // RESET !!!
            }
            if (prices[i] >= maxSoFarAfterRecentMin[1]) {
                maxSoFarAfterRecentMin[0] = i;
                maxSoFarAfterRecentMin[1] = prices[i];
            }

            if(maxSoFarAfterRecentMin[0] > minSoFar[0]){        // calculate profit only if the selling day (index) is higher than buying day
                profit = Math.max(profit, maxSoFarAfterRecentMin[1] - minSoFar[1]);
            }
        }
        return profit;
    }
}
