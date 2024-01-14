package leet.top_interview_150._01_array_string;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/?envType=study-plan-v2&envId=top-interview-150
 */
public class _07_Best_Time_To_Buy_And_Sell_Stock {

    /*
     * 시간 복잡도 : O(N)
     * 공간 복잡도 : O(1)
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int price : prices){
            // 만약 금액이 기존 최소 금액보다 적다면 갱신
            if(price < minPrice){
                minPrice = price;
            }
            // 만약 이윤이 기존 이윤보다 크다면 이윤 갱신
            else if(price - minPrice > maxProfit){
                maxProfit = price - minPrice;
            }
        }

        return maxProfit;
    }
}
