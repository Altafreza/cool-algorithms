package dynamicprograming.onedee;

public class BestTimeToSellStocks {

    // Two-pointer O(n)
    public int maxProfitA(int[] a) {
        int max = Integer.MIN_VALUE;
        int i = 0, j = i + 1;
        while (i < a.length && j < a.length) {
            if (a[i] > a[j]) {
                i = j;
                j = 1 + i;
                continue;
            } else {
                max = Math.max(max, a[j] - a[i]);
                j++;
            }
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }

    // recursive o(n)
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
