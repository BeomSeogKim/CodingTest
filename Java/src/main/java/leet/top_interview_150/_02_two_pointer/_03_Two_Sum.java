package leet.top_interview_150._02_two_pointer;

/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/?envType=study-plan-v2&envId=top-interview-150
 */
public class _03_Two_Sum {
    /*
     * Time Complexity : O(N)
     * Space Complexity : O(1)
     */
    public int[] twoSum(int[] numbers, int target) {
        int pLeft = 0, pRight = numbers.length - 1;

        while(pLeft < pRight){
            int sum = numbers[pLeft] + numbers[pRight];
            if (sum > target) {
                pRight--;
            } else if (sum <target) {
                pLeft++;
            } else {
                return new int[]{pLeft + 1, pRight + 1};
            }
        }
        return new int[]{-1};
    }
}
