package leet.top_interview_150._04_Hashmap;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-interview-150
 */
public class _10_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int count = 1;

        for (int i = 0; i < nums.length - 1; i++){
            if (nums[i + 1] != nums[i]){
                if (nums[i + 1] == nums[i] + 1){
                    count++;
                } else{
                    max = Math.max(max, count);
                    count = 1;
                }
            }

        }
        return Math.max(max, count);
    }
}
