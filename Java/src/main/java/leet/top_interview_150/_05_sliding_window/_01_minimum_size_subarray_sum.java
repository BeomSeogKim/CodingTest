package leet.top_interview_150._05_sliding_window;

/*
 * https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class _01_minimum_size_subarray_sum {
    //특정 조건이 될 때 까지 sliding window의 오른쪽 창을 증가시키고
    // 특정 조건이 만족된다면 왼쪽 창을 감소시키며 값을 찾아나가는 과정
    public int minSubArrayLen(int target, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int start = 0, end = 0, sum = 0, minLength = Integer.MAX_VALUE;

        while(end < nums.length){
            sum += nums[end++];
            while(sum >= target){
                minLength = Math.min(minLength, end - start);
                sum -= nums[start++];
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
