package leet.top_interview_150._01_array_string;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/?envType=study-plan-v2&envId=top-interview-150
 */
public class _08_Best_Time_To_Buy_And_Sell_Stock {

    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(1)
     */
    public int maxProfit(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxProfit = 0;

        while(i < prices.length - 1){
            while(i < prices.length - 1 && prices[i] >= prices[i + 1]){
                i++;
            }
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i + 1]){
                i++;
            }
            peak = prices[i];
            maxProfit += (peak - valley);
        }

        return maxProfit;
    }

    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(1)
     */
    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if (prices[i] > prices[i - 1]){
                maxProfit += (prices[i] - prices[i - 1]);
            }
        }

        return maxProfit;
    }
}
