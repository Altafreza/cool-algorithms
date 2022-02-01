package dynamicprograming.onedee;

public class BestTimeToSellStocks {

    public int maxProfit(int[] prices) {
        return dfs(prices, 0, Integer.MAX_VALUE);
    }

    protected int dfs(int[] prices, int index, int min) {
        if (index == prices.length)
            return 0;

        int minimumEndingHere = Math.min(min, prices[index]);
        int maxProfit = dfs(prices, index + 1, minimumEndingHere);
        maxProfit = Math.max(maxProfit, prices[index] - min);
        return maxProfit;
    }

}
