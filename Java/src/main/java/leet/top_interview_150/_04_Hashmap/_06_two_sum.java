package leet.top_interview_150._04_Hashmap;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class _06_two_sum {

    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        // Initializing
        for(int i = 0; i < nums.length; i++){
            int res = target - nums[i];
            if(map.containsKey(res) && map.get(res) != i){
                return new int[]{i, map.get(res)};
            } else{
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
