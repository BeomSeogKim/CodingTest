package leet.top_interview_150._04_Hashmap;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/contains-duplicate-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class _08_contains_duplicate_ii {
    /*
     * Time Complexity : O(N)
     * Space Complexity : O(N)
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i < nums.length; i++){
            int num = nums[i];
            if (map.containsKey(num)){
                int index = map.get(num);
                if(index != i && Math.abs(index - i) <= k){
                    return true;
                } else {
                    map.put(num, i);    // update
                }
            } else {
                map.put(num, i);
            }
        }
        return false;
    }
}
