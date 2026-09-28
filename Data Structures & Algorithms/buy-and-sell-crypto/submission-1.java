class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 1;
        int maxDif = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int currentDif = prices[right] - prices[left];
                maxDif = Math.max(maxDif, currentDif);
            } else {
                left = right;
            }
            right++;
        }
        return maxDif;
    }
}
