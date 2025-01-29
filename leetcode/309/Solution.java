// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int hold = Integer.MIN_VALUE;
        int sold = 0;
        int rest = 0;

        for (int price : prices) {
            int prevSold = sold;
            sold = hold + price;
            hold = Math.max(hold, rest - price);
            rest = Math.max(rest, prevSold);
        }

        return Math.max(sold, rest);
    }
}
